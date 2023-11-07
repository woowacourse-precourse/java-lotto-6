package lotto.domain;

public enum Constant {
    MINIMUM_AMOUNT_IN_UNITS(1000),
    NO_REMAINDER(0),
    GENERATE_START_NUMBER(0),
    LOTTO_MINIMUM_NUMBER(1),
    LOTTO_MAXIMUM_NUMBER(45),
    COUNT_OF_LOTTO_NUMBER(6);
    private final int value;

    Constant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}