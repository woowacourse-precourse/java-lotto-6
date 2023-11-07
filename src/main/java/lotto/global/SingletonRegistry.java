package lotto.global;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SingletonRegistry {
    private static final Map<String, Object> registry = new ConcurrentHashMap<>();

    private SingletonRegistry() {}

    public static void register(String key, Object instance) {
        if (!registry.containsKey(key)) {
            registry.put(key, instance);
        }
    }

    public static Object getInstance(String key) {
        return registry.get(key);
    }
}
