package lotto;

public enum Constraints {
    LOTTO_PRICE(1000),
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    SIZE(6);

    private final int value;

    Constraints(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}