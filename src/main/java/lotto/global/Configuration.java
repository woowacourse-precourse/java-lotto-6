package lotto.global;

public enum Configuration {
    PRICE_UNIT(1000),
    LIMIT_PRICE(1000),
    MINIMUM_RANGE_VALUE(1),
    MAXIMUM_RANGE_VALUE(45),
    PICK_COUNT(6);

    private final int value;

    private Configuration(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
