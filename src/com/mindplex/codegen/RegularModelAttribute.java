package com.mindplex.codegen;

/**
 * 
 * @author Abel Perez
 */
public class RegularModelAttribute implements ModelAttribute
{
    /** */
    private String type;

    /** */
    private String rootType;

    /** */
    private String name;

    private RegularModelAttribute(String name, String type) {
        this.rootType = type;
        this.type = type;
        this.name = name;
    }

    public static ModelAttribute of(String name, DataType type) {
        return new RegularModelAttribute(name, type.getValue());
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getRootType() {
        return rootType;
    }

    public String getInternalName() {
        return name.toLowerCase();
    }

    public String getExternalName() {
        return capitalize(name, true);
    }

    private static String capitalize(String str, boolean capitalize) {
        if (str == null || str.length() == 0) {
            return str;
        }
        StringBuffer buf = new StringBuffer(str.length());
        if (capitalize) {
            buf.append(Character.toUpperCase(str.charAt(0)));
        }
        else {
            buf.append(Character.toLowerCase(str.charAt(0)));
        }
        buf.append(str.substring(1));
        return buf.toString();
    }

    @Override public String toString() {
        return new StringBuilder("[RegularModelAttribute: ")
                .append("name=").append(getName())
                .append(", type=").append(getType())
                .append(", rootType=").append(getRootType())
                .append(", internalName=").append(getInternalName())
                .append(", externalName=").append(getExternalName())
                .append("]").toString();
    }
}
