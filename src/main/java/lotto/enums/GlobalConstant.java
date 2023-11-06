package lotto.enums;

public enum GlobalConstant {
    DIVIDE_NUMBER(1000),
    NUMBER_AMOUNT(6),
    NUMBER_MIN(1),
    NUMBER_MAX(45);

    private final int value;

    GlobalConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
