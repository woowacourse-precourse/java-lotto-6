package lotto.constant;

public enum GameConfig {

    MAX_PURCHASE_AMOUNT(100000),
    LOTTO_PRICE(1000),
    WINNING_NUMBERS_COUNT(6),
    BONUS_NUMBER_COUNT(1),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45);

    private final int value;

    GameConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
