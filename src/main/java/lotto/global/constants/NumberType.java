package lotto.global.constants;

public enum NumberType {
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45);

    private final Integer value;

    NumberType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
