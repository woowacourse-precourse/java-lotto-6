package lotto.constants;

public enum Value {
    INITIAL_ZERO(0),
    REMAINDER_ZERO(0),
    FIRST_CHARACTER(0),
    ZERO(0),
    COUNT_ONE(1),
    INDEX_MINUS_ONE(1),
    MIN_LOTTO_NUMBER(1),
    LOTTO_SIZE(6),
    MAX_LOTTO_NUMBER(45),
    ASCII_ZERO(48),
    PERCENT(100),
    THOUSAND(1000),
    LOTTO_PRICE(1000);

    private final Integer value;

    Value(Integer value) {
        this.value = value;
    }

    public Integer get() {
        return value;
    }
}
