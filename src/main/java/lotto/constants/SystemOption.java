package lotto.constants;

public enum SystemOption {
    PAYMENT_UNIT_VALUE(1000),
    TARGET_NUMBERS_SIZE_VALUE(6),
    LOWER_BOUND_LOTTO_VALUE(1),
    UPPER_BOUND_LOTTO_VALUE(45);

    private int value;

    SystemOption(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
