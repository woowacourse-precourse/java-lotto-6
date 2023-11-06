package lotto.constants;

public enum Value {
    LOTTO_SIZE(6),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    THOUSAND(1000),
    LOTTO_PRICE(1000),
    PERCENT(100),
    INITIAL_ZERO(0),
    REMAINDER_ZERO(0),
    FIRST_CHARACTER(0),
    ZERO(0),
    ASCII_ZERO(48),
    COUNT_ONE(1),
    INDEX_MINUS_ONE(1);

    private final Integer value;

    Value(Integer value) {
        this.value = value;
    }

    public Integer get() {
        return value;
    }
}
