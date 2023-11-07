package lotto.context.container.implementation.annotationConfig.annotation.configuration;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ConfigurationScanner {
    private static final String PACKAGE_DELIMITER = ".";
    private static final String DIRECTORY_DELIMITER = "/";
    private static final String CLASS_EXTENSION = ".class";
    private static final Class<? extends Annotation> ANNOTATION = Configuration.class;

    public static List<Class<?>> scan(String basePackage) {
        List<Class<?>> configurationClasses = new ArrayList<>();
        try {
            String path = basePackage.replace(PACKAGE_DELIMITER, DIRECTORY_DELIMITER);
            Enumeration<URL> resources = Thread.currentThread().getContextClassLoader().getResources(path);
            while (resources.hasMoreElements()) {
                File packageDir = new File(resources.nextElement().getFile());
                scanPackage(configurationClasses, basePackage, packageDir);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return configurationClasses;
    }

    private static void scanPackage(
            List<Class<?>> configurationClasses,
            String basePackage,
            File packageDirectory
    ) throws ClassNotFoundException {
        File[] files = packageDirectory.listFiles();
        if (files != null) {
            for (File file : files) {
                scanFile(configurationClasses, basePackage, file);
            }
        }
    }

    private static void scanFile(
            List<Class<?>> configurationClasses, String basePackage, File file
    ) throws ClassNotFoundException {
        if (file.isDirectory()) {
            scanPackage(configurationClasses, basePackage + PACKAGE_DELIMITER + file.getName(), file);
            return;
        }
        if (file.isFile() && file.getName().endsWith(CLASS_EXTENSION)) {
            Class<?> clazz = Class.forName(basePackage + PACKAGE_DELIMITER + file.getName().replace(CLASS_EXTENSION, ""));
            if (isConfigurationClass(clazz)) {
                configurationClasses.add(clazz);
            }
        }
    }

    private static boolean isConfigurationClass(Class<?> clazz) {
        return clazz.isAnnotationPresent(ANNOTATION);
    }
}
