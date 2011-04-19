package com.mindplex.codegen;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Abel Perez
 */
public class Model
{
    /** */
    private String namespace;

    /** */
    private String className;

    /** */
    private String simpleClassName;

    /** */
    private List<ModelAttribute> properties = new ArrayList<ModelAttribute>();

    public Model(String namespace, String className) {
        this.namespace = namespace;
        this.className = className;
        this.simpleClassName = className.toLowerCase();
    }
    
    public Model append(ModelAttribute property) {
        if (property == null) return this;
        properties.add(property);
        return this;
    }

    public Model append(String name, DataType type) {
        return append(RegularModelAttribute.of(name, type));
    }

    public Model addShort(String name) {
        return append(name, DataType.SHORT);
    }

    public Model addInt(String name) {
        return append(name, DataType.INT);
    }

    public Model addLong(String name) {
        return append(name, DataType.LONG);
    }

    public Model addFloat(String name) {
        return append(name, DataType.FLOAT);
    }

    public Model addDouble(String name) {
        return append(name, DataType.DOUBLE);
    }

    public Model addDecimal(String name) {
        return append(name, DataType.DECIMAL);
    }

    public Model addByte(String name) {
        return append(name, DataType.BYTE);
    }

    public Model addChar(String name) {
        return append(name, DataType.CHAR);
    }

    public Model addString(String name) {
        return append(name, DataType.STRING);
    }

    public Model addText(String name) {
        return append(name, DataType.TEXT);
    }

    public Model addLongText(String name) {
        return append(name, DataType.LONGTEXT);
    }

    public Model addBoolean(String name) {
        return append(name, DataType.BOOLEAN);
    }

    public Model addDateTime(String name) {
        return append(name, DataType.DATETIME);
    }

    public String getNamespace() {
        return namespace;
    }

    public String getClassName() {
        return className;
    }

    public String getSimpleClassName() {
        return simpleClassName.toLowerCase();
    }

    public List<ModelAttribute> getProperties() {
        return new ArrayList<ModelAttribute>(properties);
    }
    
    public Map<String, ?> getAttributes() {
        Map<String, Object> attributes = new ConcurrentHashMap<String, Object>();
        attributes.put(Attribute.NAMESPACE.name(), getNamespace());
        attributes.put(Attribute.CLASSNAME.name(), getClassName());
        attributes.put(Attribute.SIMPLECLASSNAME.name(), getSimpleClassName());
        attributes.put(Attribute.PROPERTIES.name(), getProperties());
        return attributes;
    }

    @Override public String toString() {
        return new StringBuilder("[Model: ")
                .append("namespace=").append(getNamespace())
                .append(", className=").append(getClassName())
                .append(", simpleClassName=").append(getSimpleClassName())
                .append(", properties=").append(getProperties())
                .append("]").toString();
    }
}