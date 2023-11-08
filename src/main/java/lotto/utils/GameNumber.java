package lotto.utils;

public enum GameNumber {
    UNIT(1000),
    MIN_RANGE(1),
    MAX_RANGE(45),
    THREE_MATCH(3),
    FOUR_MATCH(4),
    FIVE_MATCH(5),
    SIX_MATCH(6),
    LOTTO_SIZE(6);
    private final int number;

    GameNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
