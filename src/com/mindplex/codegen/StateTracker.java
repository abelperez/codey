package com.mindplex.codegen;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abel Perez
 */
public class StateTracker
{
    /** */
    private List<StateMemento> stateTransitions = new ArrayList<StateMemento>();

    public void addStateMemento(StateMemento state) {
        stateTransitions.add(state);
    }

    public StateMemento getStateMemento(int index) {
        return stateTransitions.get(index);
    }

    public List<StateMemento> getStateTransitions() {
        return stateTransitions;
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder("[StateTracker: {\n");
        for (StateMemento transition : getStateTransitions()) {
            sb.append(transition);    
        }
        return sb.append("\n}]").toString();
    }
}