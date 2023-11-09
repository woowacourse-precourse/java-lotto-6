package lotto.context.container;

public interface ApplicationContainer {
    int getBeanCount();

    <T> T getBean(Class<?> beanClass);

    <T> T getBean(String beanName);

    void remove(String beanName);
}
