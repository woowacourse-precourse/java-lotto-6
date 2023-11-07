package lotto;

import java.util.HashMap;
import java.util.Map;

public enum Price {
    FIRST(5, "2,000,000,000"),
    SECOND(4, "30,000,000"),
    THIRD(3, "1,500,000"),
    FORTH(2, "50,000"),
    FIFTH(1, "5,000");

    private final int key;
    private final String value;

    private static final Map<Integer, Price> priceEnumMap = new HashMap<>();

    Price(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    static {
        for (Price price : Price.values()) {
            priceEnumMap.put(price.getKey(), price);
        }
    }

    public static Price getByKey(int key) {
        return priceEnumMap.get(key);
    }
}