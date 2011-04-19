package com.mindplex.codegen.internal;

import java.io.StringWriter;
import java.util.Map;
import java.util.Properties;

import org.apache.velocity.app.Velocity;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;

/**
 *
 * @author Abel Perez
 */
public class VelocityCodeGenerator implements CodeGenerator
{
    private static final CodeGenerator soleInstance = new VelocityCodeGenerator();

    private VelocityCodeGenerator() {
        init();
    }

    public static CodeGenerator getInstance() {
        return soleInstance;
    }

    private void init() {
        Properties properties = new Properties();
        properties.put("resource.loader", "class");
        properties.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        properties.put("runtime.log", "velocity.log");

        try {
            Velocity.init(properties);

        } catch (Exception exception) {
            exception.printStackTrace();
            throw new IllegalStateException("Failed to initialize Velocity Engine.");
        }
    }

    public String generate(String template, Map<String, ?> model) throws CodeGeneratorException {
        VelocityContext context = new VelocityContext(model);
        return merge(context, template);
    }

    protected String merge(VelocityContext context, String codeTemplate) throws CodeGeneratorException {
        StringWriter writer = new StringWriter();

        try {
            Template template = Velocity.getTemplate(codeTemplate);
            template.merge(context, writer);
            String generatedCode = writer.toString();
            writer.flush();
            writer.close();
            return generatedCode;

        } catch (Exception exception) {
            throw new CodeGeneratorException("Failed to generate code.", exception);
        }
    }
}