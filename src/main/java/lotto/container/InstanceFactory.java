package lotto.container;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class InstanceFactory {
    private final Map<String, Object> instances = new HashMap<>();

    public int getInstanceCount() {
        return instances.size();
    }

    public boolean hasInstanceOf(String instanceName) {
        return !instances.containsKey(instanceName);
    }

    public <T> T get(String instanceName) {
        T instance = (T) instances.get(instanceName);
        if (instance == null) {
            throw new NoSuchInstanceException(instanceName);
        }
        return instance;
    }

    public <T> void registerInstance(String instanceName, Supplier<T> instanceSupplier) {
        instances.put(instanceName, instanceSupplier.get());
    }

    private <T> T getInstance(String instanceName, Supplier<T> instanceSupplier) {
        if (hasInstanceOf(instanceName)) {
            registerInstance(instanceName, instanceSupplier);
        }
        return (T) instances.get(instanceName);
    }
}
