package lotto.container.container.implementation;

import lotto.container.beanFactory.BeanFactory;
import lotto.container.container.ApplicationContainer;
import lotto.container.exception.NoSuchBeanException;
import lotto.container.exception.UndefinedBeanConfigurationException;
import lotto.annotation.bean.BeanScanner;
import lotto.annotation.configuration.ConfigurationScanner;
import lotto.container.container.Strategy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Supplier;

public class AnnotationApplicationContainer implements ApplicationContainer {
    private final Strategy strategy;
    private final BeanFactory factory;
    private final List<Class<?>> annotatedClasses;
    private final List<Method> annotatedMethods;

    public AnnotationApplicationContainer(BeanFactory factory, Strategy strategy, String basePackage) {
        this.factory = factory;
        this.strategy = strategy;
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
    @SuppressWarnings("unchecked")
    public <T> T getOrRegisterBean(String beanName) {
        if (!factory.contains(beanName)) {
            registerBeanByAnnotation(beanName);
        }
        return (T) factory.getBean(beanName);
    }

    private void init() {
        for (Class<?> clazz : annotatedClasses) {
            registerConfig(clazz);
            annotatedMethods.addAll(BeanScanner.scan(clazz));
        }

        if (strategy.equals(Strategy.EAGER)) {
            for (Method method : annotatedMethods) {
                registerBeanByAnnotation(method.getName());
            }
        }
    }

    private void registerConfig(Class<?> configClass) {
        String beanName = prefix(configClass.getSimpleName());
        factory.registerBean(beanName, getSupplier(configClass));
    }

    @SuppressWarnings("unchecked")
    private <T> Supplier<T> getSupplier(Class<?> clazz) {
        return () -> {
            try {
                return (T) clazz.getDeclaredConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException |
                     InvocationTargetException e) {
                throw new UndefinedBeanConfigurationException(prefix(clazz.getSimpleName()));
            }
        };
    }

    private void registerBeanByAnnotation(String beanName) {
        Method method = findBeanCreationMethod(beanName);

        Object[] args = Arrays.stream(method.getParameters())
                .map(param -> prefix(param.getType().getSimpleName()))
                .map(this::getOrRegisterBean)
                .toArray();

        factory.registerBean(beanName, () -> {
            try {
                return method.invoke(getBean(method.getDeclaringClass()), args);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private Method findBeanCreationMethod(String beanName) {
        return annotatedMethods.stream()
                .filter(m -> m.getName().equals(beanName))
                .findAny()
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
