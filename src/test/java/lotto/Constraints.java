package lotto;

public enum Constraints {
    LOTTO_PRICE(1000);

    private final int value;

    Constraints(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}