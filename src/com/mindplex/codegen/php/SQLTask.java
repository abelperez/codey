package com.mindplex.codegen.php;

import java.io.File;

import com.mindplex.codegen.*;

/**
 * SQLTask generates SQL based data definition source code for tables that
 * map directly to the model provided to this task.
 *
 * @author Abel Perez
 */
public class SQLTask extends AbstractSourceCodeTask implements SourceCodeTask
{
    /**
     * The name of the source code template.
     *
     * @return name of the source code template.
     */
    @Override public String getTemplateName() {
        return "Entity.sql";
    }

    /**
     * Gets the absolute path to the directory where the generated source code
     * should be written to.
     *
     * @param model the model that this task is currently processing.
     *
     * @return the absolute path to the directory where the generated source code
     * should be written to.
     */
    public String getOutputPath(Model model) {
        return Configuration.getInstance().getOutputDir() + File.separator + "model";
    }

    /**
     * Gets the name for the generated source code file.
     *
     * @param model the model that this task is currently processing.
     *
     * @return the name for the generated source code file.
     */    
    @Override public String getOutputFilename(Model model) {
        return model.getNamespace() + File.separator + model.getClassName() + ".sql";
    }

    /**
     * Generates the SQL based data definition source code that's maps to the
     * model this task is processing.
     *
     * @param context the context this task requires for code generation.
     *
     * @throws SourceCodeGeneratorException can occur if the code generation
     * process fails.
     */    
    @Override public void invoke(SourceCodeContext context) throws SourceCodeGeneratorException {
        super.invoke(context);
    }
}
