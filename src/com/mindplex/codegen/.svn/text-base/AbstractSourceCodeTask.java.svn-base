package com.mindplex.codegen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.mindplex.codegen.internal.CodeGenerator;
import com.mindplex.codegen.internal.CodeGeneratorFactory;

/**
 *
 *  @author Abel Perez
 */
public abstract class AbstractSourceCodeTask implements SourceCodeTask
{
    /** */
    private static Logger logger;

    public AbstractSourceCodeTask() {
    }

    public abstract String getTemplateName();

    public abstract String getOutputPath(Model model);

    public abstract String getOutputFilename(Model model);

    public String getTemplateDir() {
        return Configuration.getInstance().getTemplateDir();
    }

    public String getAbsoluteTemplate() {
        return getTemplateDir() + File.separator + getTemplateName();
    }

    public void invoke(SourceCodeContext context) throws SourceCodeGeneratorException {
        try {
            getLog().info("invoking " + getClass().getSimpleName());

            for(Model model : getModels(context)) {
                String code = generate(model, context);
                serialize(getOutputPath(model), getOutputFilename(model), code);
            }
            context.invokeNext();
            
        } catch (Exception exception) {
            throw new SourceCodeGeneratorException("Failed to invoke source code task.", exception);
        }
    }

    protected String generate(Model model, SourceCodeContext context) throws SourceCodeGeneratorException {
        try {
            String src = getCodeGenerator().generate(getAbsoluteTemplate(), model.getAttributes());
            context.getBuffer().append(src).append("\n");
            serialize(getOutputPath(model), getOutputFilename(model), src);
            return src;

        } catch (Exception exception) {
            throw new SourceCodeGeneratorException("Failed to generate code from task: " + getClass().getSimpleName(), exception);
        }

    }

    protected CodeGenerator getCodeGenerator() {
        return CodeGeneratorFactory.Create();
    }

    @SuppressWarnings("unchecked")
    protected List<Model> getModels(SourceCodeContext context) {
        return (List<Model>)context.getValue(SourceCodeContext.MODELS);
    }

    protected void serialize(String path, String filename, String script) throws Exception {

        File file = new File(filename);
        File dir = new File(path);

        boolean success = dir.mkdirs();
        if (success) {
            getLog().info("created dir: " + dir.getAbsolutePath());
        }

        BufferedWriter out = new BufferedWriter(new FileWriter(dir.getAbsolutePath() + File.separator + file.getName()));
        out.write(script);
        out.close();
    }

    protected Logger getLog() {
        if (logger == null) {
            synchronized(AbstractSourceCodeTask.class) {
                if (logger == null) {
                    logger = Logger.getLogger(getClass().getName());
                }
            }
        }
        return logger;
    }
}