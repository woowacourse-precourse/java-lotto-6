package lotto.constant;

public enum NumberUtil {
    LOTTO_PRICE(1000),
    START_NUMBER(1),
    END_NUMBER(45),
    LOTTO_COUNT_LIMIT(6),
    BONUS_KEY_FIVE(5),
    DEFAULT_VALUE(0),
    PROFIT_PERCENT(100),
    MAX_NUMBER(2100000000),
    MIN_NUMBER(0),
    MIN_WINNING_COUNT(3);

    private final int number;

    NumberUtil(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
