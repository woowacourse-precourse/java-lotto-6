package lotto.util;

public enum Constant {

    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    START_INCLUSIVE(1),
    END_INCLUSIVE(45),
    LOTTO_NUMBER_COUNT(6),
    LOTTO_PRICE(1_000),
    ZERO(0);

    private final int value;

    Constant(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
