package lotto.utils;

public enum GameNumber {
    UNIT(1000),
    MIN_RANGE(1),
    MAX_RANGE(45),
    LOTTO_SIZE(6);
    private final int number;

    GameNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
