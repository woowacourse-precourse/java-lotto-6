package lotto;

public enum IntegerUtil {

    PAY_AMOUNT_UNIT(1000),
    LOTTO_NUMBER_COUNT(6),
    BUNUS_NUMBER_COUNT(1);

    private int value;

    IntegerUtil(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
