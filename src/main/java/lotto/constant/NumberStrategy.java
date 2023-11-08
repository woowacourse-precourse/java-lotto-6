package lotto.constant;

public enum NumberStrategy {
    MAX_NUMBER(45),
    MIN_NUMBER(1),
    LOTTO_NUMBER_COUNT(6);

    private final int number;

    NumberStrategy(int i) {
        this.number = i;
    }

    public int getNumber() {
        return number;
    }
}