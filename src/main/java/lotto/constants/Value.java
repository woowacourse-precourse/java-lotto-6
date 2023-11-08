package lotto.constants;

public enum Value {
    LOTTO_SIZE(6),
    UNIT_OF_AMOUNT(1000),
    REMAINDER_ZERO(0),
    ZERO(0);

    private final int value;

    Value(int value) {
        this.value = value;
    }

    public int get() {
        return value;
    }
}
