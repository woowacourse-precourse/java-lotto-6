package lotto.constant;

public enum Number {
    ZERO(0),
    MINIMUM(1),
    MAXIMUM(45),
    PRICE(1000),
    SIZE(6);

    private final int value;

    Number(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
};