package lotto.context.container.implementation;

import lotto.config.ApplicationConfig;
import lotto.context.beanFactory.BeanFactory;
import lotto.context.container.ApplicationContainer;
import lotto.context.exception.NoSuchBeanException;
import lotto.context.exception.UndefinedBeanConfigurationException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

@Deprecated
public class DefaultApplicationContainer implements ApplicationContainer {
    private final BeanFactory factory;
    private final ApplicationConfig config;

    public DefaultApplicationContainer(BeanFactory factory, ApplicationConfig config) {
        this.factory = factory;
        this.config = config;
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
            registerBeanByConfig(beanName);
            return factory.getBean(beanName);
        }
    }

    @Override
    public void remove(String beanName) {
        factory.remove(beanName);
    }

    private void registerBeanByConfig(Class<?> beanClass) {
        String beanName = prefix(beanClass.getSimpleName());
        registerBeanByConfig(beanName);
    }

    private void registerBeanByConfig(String beanName) {
        Method method = findBeanCreationMethod(beanName);

        Object[] args = Arrays.stream(method.getParameters())
                .map(param -> prefix(param.getType().getSimpleName()))
                .map(this::getBean)
                .toArray();

        factory.registerBean(beanName, () -> {
            try {
                return method.invoke(config, args);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private Method findBeanCreationMethod(String beanName) {
        return Arrays.stream(config.getClass().getMethods())
                .filter(method -> method.getName().equals(beanName))
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
