package lotto.constant;

public enum GameNumber {

    MIN_LOTTO_AMOUNT(1),
    MAX_LOTTO_AMOUNT(100),
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    NORMAL_NUMBER_COUNT(6),
    BONUS_NUMBER_COUNT(1);

    private final long number;

    GameNumber(long number) {
        this.number = number;
    }
}
