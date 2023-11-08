package lotto.utils;

public enum NumberConstant {
    MIN(1),
    MAX(45),
    SIZE(6),
    PRICE_UNIT(1000),
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(15000000),
    FOURTH(50000),
    FIFTH(5000);
    private final int value;

    NumberConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
