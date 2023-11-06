package lotto.enums;

public enum Constant {
    COUNT_OF_LOTTO_NUMBERS(6),
    START_RANGE_OF_NUMBER(1),
    END_RANGE_OF_NUMBER(45);

    private Integer value;

    Constant (Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
