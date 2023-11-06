package lotto.context.beanFactory;

import java.util.function.Supplier;

public interface BeanFactory {
    int getBeanCount();

    boolean contains(String beanName);

    <T> T getBean(String beanName);

    <T> void registerBean(String beanName, Supplier<T> beanSupplier);

    void remove(String beanName);
}
