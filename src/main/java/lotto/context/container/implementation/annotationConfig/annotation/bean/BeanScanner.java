package lotto.context.container.implementation.annotationConfig.annotation.bean;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class BeanScanner {
    private static final Class<? extends Annotation> ANNOTATION = Bean.class;

    public static List<Method> scan(Class<?> configurationClass) {
        List<Method> beanMethods = new ArrayList<>();
        Method[] methods = configurationClass.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(ANNOTATION)) {
                beanMethods.add(method);
            }
        }

        return beanMethods;
    }
}
