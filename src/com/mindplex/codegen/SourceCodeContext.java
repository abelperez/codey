package com.mindplex.codegen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * @author Abel Perez
 */
public class SourceCodeContext
{
    /** */
    public static final String MODELS = "models";

    /** */
    private int index = 0;

    /** */
    private StringBuilder buffer = new StringBuilder();

    /** */
    private List<SourceCodeTask> tasks = new ArrayList<SourceCodeTask>();

    /** */
    private StateTracker stateTracker = new StateTracker();

    /** */
    private Map<String, Object> context = new ConcurrentHashMap<String, Object>();

    public SourceCodeContext() {
    }

    public SourceCodeContext invokeNext() throws SourceCodeGeneratorException {

        if (index > 0) {
            captureState();
        }

        int current = index;
        index = index + 1;

        if (current < tasks.size()) {
            tasks.get(current).invoke(this);

        } else if (current == tasks.size()) {
            // post task list execution here.
        }
        return this;
    }
    
    public StringBuilder getBuffer() {
        return buffer;
    }

    public List<SourceCodeTask> getTasks() {
        return new ArrayList<SourceCodeTask>(tasks);
    }

    public SourceCodeContext addTask(SourceCodeTask task) {
        if (task == null) return this;
        tasks.add(task);
        return this;
    }

    public SourceCodeContext addTasks(List<SourceCodeTask> tasks) {
        if (tasks == null) return this;
        this.tasks = tasks;
        return this;
    }

    public Object getValue(String key) {
        return context.get(key);
    }

    public SourceCodeContext setValue(String key, Object value) {
        this.context.put(key, value);
        return this;
    }

    public StateTracker getStateTracker() {
        return stateTracker;
    }

    private SourceCodeContext captureState() {
        stateTracker.addStateMemento(new StateMemento(getBuffer().toString()));
        return this;
    }    
}