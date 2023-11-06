package lotto.context.beanFactory;

import lotto.context.exception.NoSuchBeanException;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class SimpleBeanFactory implements BeanFactory {
    private final Map<String, Object> storage = new HashMap<>();

    @Override
    public int getBeanCount() {
        return storage.size();
    }

    @Override
    public boolean contains(String beanName) {
        return storage.containsKey(beanName);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getBean(String beanName) {
        if (!contains(beanName)) {
            throw new NoSuchBeanException(beanName);
        }
        return (T) storage.get(beanName);
    }

    @Override
    public <T> void registerBean(String beanName, Supplier<T> beanSupplier) {
        T bean = beanSupplier.get();
        storage.put(beanName, bean);
    }

    @Override
    public void remove(String beanName) {
        if (!contains(beanName)) {
            throw new NoSuchBeanException(beanName);
        }
        storage.remove(beanName);
    }
}
