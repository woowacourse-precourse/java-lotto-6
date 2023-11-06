package lotto.enums;

public enum GlobalConstant {
    DIVIDE_NUMBER(1000),
    LOTTO_NUMBER_SIZE(6),
    LOTTO_NUMBER_MIN(1),
    LOTTO_NUMBER_MAX(45);

    private final int value;

    GlobalConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
