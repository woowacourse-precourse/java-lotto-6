package lotto.utils;

public enum Constant {
    MIN_MONEY(1000),
    MIN_LOTTO(1),
    MAX_LOTTO(45),
    LOTTO_SIZE(6);

    private final int value;

    Constant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
