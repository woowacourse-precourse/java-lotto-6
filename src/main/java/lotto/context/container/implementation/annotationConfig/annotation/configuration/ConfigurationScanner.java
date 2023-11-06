package lotto.context.container.implementation.annotationConfig.annotation.configuration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ConfigurationScanner {
    public static List<Class<?>> scan(String basePackage) {
        List<Class<?>> configurationClasses = new ArrayList<>();
        try {
            String path = basePackage.replace('.', '/');
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
            File packageDir
    ) throws ClassNotFoundException {
        File[] files = packageDir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanPackage(configurationClasses, basePackage + "." + file.getName(), file);
                } else if (file.isFile() && file.getName().endsWith(".class")) {
                    Class<?> clazz = Class.forName(basePackage + "." + file.getName().replace(".class", ""));
                    if (isConfigurationClass(clazz)) {
                        configurationClasses.add(clazz);
                    }
                }
            }
        }
    }

    private static boolean isConfigurationClass(Class<?> clazz) {
        return clazz.isAnnotationPresent(Configuration.class);
    }
}
