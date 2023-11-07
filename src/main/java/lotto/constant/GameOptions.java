package lotto.constant;

public enum GameOptions {
    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45),
    LOTTO_NUMBER_COUNT(6),
    LOTTO_PRICE(1000);

    private int value;

    private GameOptions(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
