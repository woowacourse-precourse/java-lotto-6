package lotto.context.beanFactory;

import lotto.context.exception.BeanException;

import java.util.function.Supplier;

public interface BeanFactory {
    int getBeanCount();

    boolean contains(String beanName);

    <T> T getBean(String beanName) throws BeanException;

    <T> void registerBean(String beanName, Supplier<T> beanSupplier) throws BeanException;

    void remove(String beanName) throws BeanException;
}
