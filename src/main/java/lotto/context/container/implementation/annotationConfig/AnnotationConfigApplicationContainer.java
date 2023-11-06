package lotto.context.container.implementation.annotationConfig;

import lotto.context.beanFactory.BeanFactory;
import lotto.context.container.ApplicationContainer;
import lotto.context.exception.NoSuchBeanException;
import lotto.context.exception.UndefinedBeanConfigurationException;
import lotto.context.container.implementation.annotationConfig.annotation.bean.BeanScanner;
import lotto.context.container.implementation.annotationConfig.annotation.configuration.ConfigurationScanner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Supplier;

public class AnnotationConfigApplicationContainer implements ApplicationContainer {
    private final LoadingStrategy loadingStrategy;
    private final BeanFactory factory;
    private final List<Class<?>> annotatedClasses;
    private final List<Method> annotatedMethods;

    public AnnotationConfigApplicationContainer(BeanFactory factory, LoadingStrategy loadingStrategy, String basePackage) {
        this.factory = factory;
        this.loadingStrategy = loadingStrategy;
        this.annotatedClasses = ConfigurationScanner.scan(basePackage);
        this.annotatedMethods = new ArrayList<>();
        init();
    }

    @Override
    public int getBeanCount() {
        return factory.getBeanCount();
    }

    @Override
    public <T> T getBean(Class<?> beanClass) {
        return getBean(prefix(beanClass.getSimpleName()));
    }

    @Override
    public <T> T getBean(String beanName) {
        try {
            return factory.getBean(beanName);
        } catch (NoSuchBeanException e) {
            registerBeanByAnnotation(beanName);
            return factory.getBean(beanName);
        }
    }

    @Override
    public void remove(String beanName) {
        factory.remove(beanName);
    }

    private void init() {
        for (Class<?> clazz : annotatedClasses) {
            registerConfig(clazz);
            annotatedMethods.addAll(BeanScanner.scan(clazz));
        }

        if (loadingStrategy.equals(LoadingStrategy.EAGER)) {
            annotatedMethods.forEach(method -> registerBeanByAnnotation(method.getName()));
        }
    }

    private void registerConfig(Class<?> configClass) {
        String beanName = prefix(configClass.getSimpleName());
        factory.registerBean(beanName, getSupplier(configClass));
    }

    private Supplier<?> getSupplier(Class<?> clazz) {
        return () -> {
            try {
                return clazz.getDeclaredConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                throw new UndefinedBeanConfigurationException(prefix(clazz.getSimpleName()));
            }
        };
    }

    private void registerBeanByAnnotation(String beanName) {
        Method method = findBeanCreationMethod(beanName);

        Object[] args = Arrays.stream(method.getParameters())
                .map(param -> prefix(param.getType().getSimpleName()))
                .map(this::getBean)
                .toArray();

        factory.registerBean(beanName, () -> {
            try {
                return method.invoke(getBean(method.getDeclaringClass()), args);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new UndefinedBeanConfigurationException(beanName);
            }
        });
    }

    private Method findBeanCreationMethod(String beanName) {
        return annotatedMethods.stream()
                .filter(m -> m.getName().equals(beanName))
                .findFirst()
                .orElseThrow(() -> new UndefinedBeanConfigurationException(beanName));
    }

    private String prefix(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        char firstChar = Character.toLowerCase(input.charAt(0));
        return firstChar + input.substring(1);
    }
}