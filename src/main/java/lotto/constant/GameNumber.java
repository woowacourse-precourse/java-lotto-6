package lotto.constant;

public enum GameNumber {
    NUMBERS_PER_LOTTO(6);

    private final int number;

    private GameNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
