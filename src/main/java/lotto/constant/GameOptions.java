package lotto.constant;

public enum GameOptions {
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    NUMBER_COUNT(6),
    PRICE(1000);

    private int value;

    private GameOptions(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
