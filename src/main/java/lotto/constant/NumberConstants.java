package lotto.constant;

public enum NumberConstants {
    LOTTO_PRICE(1000),
    WINNING_NUMBER_TOTAL(6),
    BONUS_NUMBER_TOTAL(1),
    LOTTO_NUMBER_MIN_RANGE(1),
    LOTTO_NUMBER_MAX_RANGE(45)
    ;

    private final Integer number;

    NumberConstants(Integer number) {
        this.number = number;
    }

    public Integer getValue() {
        return this.number;
    }
}
