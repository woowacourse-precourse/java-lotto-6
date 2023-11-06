package lotto.context.container.implementation.annotationConfig.annotation.bean;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class BeanScanner {
    public static List<Method> scan(Class<?> configurationClass) {
        List<Method> beanMethods = new ArrayList<>();
        Method[] methods = configurationClass.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Bean.class)) {
                beanMethods.add(method);
            }
        }

        return beanMethods;
    }
}
