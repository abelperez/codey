package com.mindplex.codegen;

import java.util.ArrayList;
import java.util.List;

import com.mindplex.codegen.php.ActiveRecordTask;
import com.mindplex.codegen.php.ControllerTask;
import com.mindplex.codegen.php.SQLTask;

/**
 *
 * @author Abel Perez
 */
public class SourceCodeTaskFactory
{
    public static List<SourceCodeTask> phpTasks() {
        List<SourceCodeTask> tasks = new ArrayList<SourceCodeTask>();
        tasks.add(new SQLTask());
        tasks.add(new ActiveRecordTask());
        tasks.add(new ControllerTask());
        return tasks;
    }
}