package lotto.global.constants;

public enum NumberType {
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    COST_UNIT(1000),
    LOTTO_SIZE(6);

    private final Integer value;

    NumberType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
