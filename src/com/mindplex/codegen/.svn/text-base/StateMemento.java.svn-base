package com.mindplex.codegen;

/**
 * 
 * @author Abel Perez
 */
public class StateMemento
{
    /** */
    private String generatedCode;

    public String getGeneratedCode() {
        return generatedCode;
    }

    public void setGeneratedCode(String generatedCode) {
        this.generatedCode = generatedCode;
    }

    public StateMemento(String generatedCode) {
        this.generatedCode = generatedCode;
    }

    @Override public String toString() {
        return new StringBuilder("[StateMemento: ")
                .append("src=\n").append(getGeneratedCode())
                .append("\n]").toString();
    }
}