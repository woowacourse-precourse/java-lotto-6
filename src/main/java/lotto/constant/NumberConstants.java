package lotto.constant;

public enum NumberConstants {
    LOTTO_PRICE(1000),
    WINNING_NUMBER_TOTAL(6),
    BONUS_NUMBER_TOTAL(1),
    LOTTO_NUMBER_MIN_RANGE(1),
    LOTTO_NUMBER_MAX_RANGE(45),
    FIRST_PRIZE_MATCH_COUNT(6),
    SECOND_PRIZE_MATCH_COUNT(5),
    THIRD_PRIZE_MATCH_COUNT(5),
    FOURTH_PRIZE_MATCH_COUNT(4),
    FIFTH_PRIZE_MATCH_COUNT(3),
    FIRST_PRIZE_MONEY(2000000000),
    SECOND_PRIZE_MONEY(30000000),
    THIRD_PRIZE_MONEY(1500000),
    FORTH_PRIZE_MONEY(50000),
    FIFTH_PRIZE_MONEY(5000),
    ;

    private final Integer number;

    NumberConstants(Integer number) {
        this.number = number;
    }

    public Integer getValue() {
        return this.number;
    }
}
