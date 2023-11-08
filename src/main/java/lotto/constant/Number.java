package lotto.constant;

public enum Number {
    LOTTO_LENGTH_LIMIT(6),
    THE_SMALLEST_LOTTO_NUMBER(1),
    THE_BIGGEST_LOTTO_NUMBER(45),
    HIT_COUNT_INDEX(0),
    HIT_BONUS_INDEX(1),
    WINNING_AMOUNT_INDEX(2),
    LOTTO_PRICE(1000),
    PERSENT(100);

    private final int message;

    Number(int message) {
        this.message = message;
    }

    public final int getMessage() {
        return message;
    }
}
