package lotto.utility;

public enum IntegerUtil {

    PAY_AMOUNT_UNIT(1000),
    LOTTO_NUMBER_COUNT(6),
    LOTTO_NUMBER_START_INCLUSIVE(1),
    LOTTO_NUMBER_END_INCLUSIVE(45);

    private final int value;

    IntegerUtil(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
