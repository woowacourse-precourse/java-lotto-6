package lotto.constants;

public enum DomainConstants {

    LOTTO_NUMBER_COUNT(6),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),

    LOTTO_MIN_WINNING_NUMBER_MATCH_COUNT(3),

    ONE_LOTTO_PURCHASE_AMOUNT(1_000),
    NO_CHANGE(0),

    ONE_COUNT(1),
    COUNT_END(0),

    PERCENT(100);

    private final int value;

    DomainConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
