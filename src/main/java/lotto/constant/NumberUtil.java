package lotto.constant;

public enum NumberUtil {

    LOTTO_PRICE(1000),
    START_INDEX(1),
    END_INDEX(45),
    LOTTO_COUNT_LIMIT(6),
    BONUS_KEY_FIVE(5),
    DEFAULT_VALUE(0),
    PROFIT_PERCENT(100),
    MAX_NUMBER(2100000000),
    MIN_NUMBER(0);

    private final int number;

    NumberUtil(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
