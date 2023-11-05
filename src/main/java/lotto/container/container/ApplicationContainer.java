package lotto.container.container;

public interface ApplicationContainer {
    int getBeanCount();

    <T> T getBean(Class<?> beanClass);

    <T> T getBean(String beanName);

    <T> T getOrRegisterBean(String beanName);
}
