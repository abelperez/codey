package com.mindplex.codegen;

import java.util.List;
import java.util.ArrayList;

import org.apache.log4j.Logger;

/**
 * 
 * @author Abel Perez
 */
public class RegularSourceCodeGenerator implements SourceCodeGenerator
{
    /** */
    private static final Logger logger = Logger.getLogger(RegularSourceCodeGenerator.class);

    /** */
    private List<Model> models = new ArrayList<Model>();

    /** */
    private SourceCodeContext context = new SourceCodeContext();

    public RegularSourceCodeGenerator(List<SourceCodeTask> tasks) {
        if (tasks == null) throw new IllegalArgumentException("source code task list cannot be null.");
        context.addTasks(new ArrayList<SourceCodeTask>(tasks));
    }

    public SourceCodeGenerator addModel(Model model) {
        if (model == null) return this;
        models.add(model);
        return this;
    }

    public String generate() throws SourceCodeGeneratorException {
        logger.info("Executing source code generator...");

        try {
            if (models.isEmpty()) {
                logger.warn("Please specify at least one SourceCodeTask.");
                return "";
            }

            context.setValue(SourceCodeContext.MODELS, models);
            context.invokeNext();
            return context.getBuffer().toString();

        } catch(Exception exception) {
            logger.warn("Failed to generate source code.", exception);
            throw new RuntimeException("Failed to generate source code.", exception);
        }
    }
}