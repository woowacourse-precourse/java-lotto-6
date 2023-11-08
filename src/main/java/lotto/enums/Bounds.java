package lotto.enums;

public enum Bounds {
    LOWER_BOUND(1),
    UPPER_BOUND(45),
    MAX_LOTTO_SIZE(6),
    LOTTO_PRICE(1000);

    private final int value;

    Bounds(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
