package lotto.utils;

public enum Constants {
    MAX_NUMBER(45),
    MIN_NUMBER(1),
    LOTTO_NUMBER_COUNT(6),
    LOTTO_PRICE_PER_UNIT(1000);

    private final int number;

    Constants(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
