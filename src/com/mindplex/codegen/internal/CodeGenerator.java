package com.mindplex.codegen.internal;

import java.util.Map;

/**
 *
 * @author Abel Perez
 */
public interface CodeGenerator
{
    public String generate(String templateFilename, Map<String, ?> model) throws CodeGeneratorException;
}
