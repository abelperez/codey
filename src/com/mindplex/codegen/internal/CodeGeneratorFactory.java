package com.mindplex.codegen.internal;

/**
 *
 * @author Abel Perez
 */
public class CodeGeneratorFactory
{
    public static CodeGenerator Create() {
        return VelocityCodeGenerator.getInstance();
    }
}
