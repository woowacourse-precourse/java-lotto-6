package lotto.constant;

public enum GameNumber {
    NUMBERS_PER_LOTTO(6),
    MIN_NUMBER(1),
    MAX_NUMBER(45);

    private final int number;

    private GameNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
