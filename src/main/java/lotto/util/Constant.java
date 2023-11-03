package lotto.util;

public enum Constant {

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
