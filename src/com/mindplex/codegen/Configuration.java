package com.mindplex.codegen;

import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Configuration provides access to the configurable properties of the source
 * code generation engine.
 *
 * @author Abel Perez
 */
public class Configuration
{
    /** Properties file extension. */
    private static final String EXT = ".properties";

    /** Properties filename. */
    private static final String FILENAME = "codegen";

    /** Sole instance of Configuration. */
    private static volatile Configuration configuration;

    private Properties properties;

    /**
     * Prevent instantiation from outside of this class.
     */
    private Configuration() {    
    }

    /**
     * Gets singleton instance of Configuration.
     *
     * @return singleton instance of Configuration.
     */
    public static Configuration getInstance() {
        if (configuration == null) {
            synchronized(Configuration.class) {
                configuration = new Configuration();
                configuration.load();
            }
        }
        return configuration;
    }

    public String getValue(String key) {
        return properties.getProperty(key);
    }

    public String getOutputDir() {
        return getValue("output.directory");    
    }

    public String getTemplateDir() {
        return getValue("template.directory");    
    }

    private void load() {
        properties = load(FILENAME, Thread.currentThread().getContextClassLoader());
    }
    
    /**
     * Looks up a resource named 'name' in the classpath. The resource must map
     * to a file with .properties extention. The name is assumed to be absolute
     * and can use either "/" or "." for package segment separation with an
     * optional leading "/" and optional ".properties" suffix. Thus, the
     * following names refer to the same resource:
     * <pre>
     * some.pkg.Resource
     * some.pkg.Resource.properties
     * some/pkg/Resource
     * some/pkg/Resource.properties
     * /some/pkg/Resource
     * /some/pkg/Resource.properties
     * </pre>
     *
     * @param name classpath resource name [may not be null]
     * @param loader classloader through which to load the resource [null
     * is equivalent to the application loader]
     *
     * @return resource converted to java.util.Properties [may be null if the
     * resource was not found and THROW_ON_LOAD_FAILURE is false]
     * 
     * @throws IllegalArgumentException if the resource was not found and
     */
    public static Properties load(String name, ClassLoader loader) {

        if (name.startsWith("/")) {
            name = name.substring(1);
        }

        if (name.endsWith(EXT)) {
            name = name.substring(0, name.length() - EXT.length());
        }

        try {
            if (loader == null) {
                loader = ClassLoader.getSystemClassLoader();
            }
            
            name = name.replace ('/', '.');

            // Throws MissingResourceException on lookup failures:
            ResourceBundle rb = ResourceBundle.getBundle(name, Locale.getDefault(), loader);
            Properties properties = new Properties();
            
            for (Enumeration keys = rb.getKeys(); keys.hasMoreElements();) {
                String key = (String) keys.nextElement();
                String value = rb.getString(key);
                properties.put(key, value);
            }

            return properties;
            
        } catch (Exception exception) {
            throw new IllegalArgumentException("could not load resource: " + name);
        }
    }
}     
