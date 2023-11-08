package lotto.constants;

public enum DomainConstants {

    LOTTO_MIN_NUMBER_MATCH_COUNT(0),
    LOTTO_MIN_WINNING_NUMBER_MATCH_COUNT(3),
    FIFTH_NUMBER_MATCH_COUNT(3),
    FOURTH_NUMBER_MATCH_COUNT(4),
    THIRD_NUMBER_MATCH_COUNT(5),
    SECOND_NUMBER_MATCH_COUNT(5),
    FIRST_NUMBER_MATCH_COUNT(6),

    LOTTO_NUMBER_COUNT(6),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),

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
