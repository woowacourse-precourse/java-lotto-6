package constants;

public enum NumberType {

    LOTTO_PRICE(2);

    private final int value;

    NumberType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
