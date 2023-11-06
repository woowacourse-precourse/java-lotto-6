package lotto.constant;

public enum GameConfig {

    MAX_PURCHASE_AMOUNT(100_000),
    LOTTO_PRICE(1_000),
    WINNING_NUMBERS_COUNT(6),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    ZERO(0);

    private final int value;

    GameConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
