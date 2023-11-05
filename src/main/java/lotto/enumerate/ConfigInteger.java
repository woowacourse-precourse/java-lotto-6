package lotto.enumerate;

public enum ConfigInteger {
    LOTTO_PRICE(1000),
    ZERO(0),
    ONE(1),
    DECIMAL_PLACE(1),
    LOTTO_START_NUMBER(1),
    LOTTO_END_NUMBER(45),
    LOTTO_NUMBER_COUNT(6),
    LONG_ROUND_NUMBER(1000),
    LONG_ROUND_DIVIDE_NUMBER(100);

    private int i;

    ConfigInteger(int i) {
        this.i = i;
    }

    public int getInt() {
        return i;
    }
}
