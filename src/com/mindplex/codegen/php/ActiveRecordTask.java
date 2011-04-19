package com.mindplex.codegen.php;

import java.io.File;

import com.mindplex.codegen.*;

/**
 * ActiveRecordTask generates the source code for a PHP based ActiveRecord.
 * The generated active record contains the semantics defined in the model
 * that is given to this task for processing.
 *  
 * @author Abel Perez
 */
public class ActiveRecordTask extends AbstractSourceCodeTask implements SourceCodeTask
{
    /**
     * The name of the source code template.
     *
     * @return name of the source code template.
     */
    @Override public String getTemplateName() {
        return "ActiveRecord.php";    
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
    @Override public String getOutputPath(Model model) {
        return Configuration.getInstance().getOutputDir() + File.separator + "data" + File.separator + model.getNamespace().toLowerCase();
    }

    /**
     * Gets the name for the generated source code file.
     *
     * @param model the model that this task is currently processing.
     *
     * @return the name for the generated source code file.
     */
    @Override public String getOutputFilename(Model model) {
        return model.getClassName() + ".php";
    }

    /**
     * Generates the source code for a PHP based ActiveRecord.
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