package lotto;

public enum IntegerUtil {

    PAY_AMOUNT_UNIT(1000);

    private int value;

    IntegerUtil(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
