package com.mindplex.codegen;

import java.util.List;

/**
 *
 */
public class Main
{
    public static void main(String[] args) throws Exception {

        Model person = new Model("scala", "Person");
        person.addLong("id").addString("firstname").addString("lastname").addDateTime("created");

        List<SourceCodeTask> tasks = SourceCodeTaskFactory.phpTasks();
        SourceCodeGenerator codegen = new RegularSourceCodeGenerator(tasks);
        codegen.addModel(person);
        codegen.generate();
    }
}
