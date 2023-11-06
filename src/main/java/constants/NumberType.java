package constants;

public enum NumberType {

    LOTTO_PRICE(1000),
    LOTTO_LENGTH(6),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45);

    private final int value;

    NumberType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
