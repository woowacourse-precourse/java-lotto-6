package lotto.enums;

public enum Constants {
    LOTTO_PRICE(1000),
    INITIAL_COUNT(0),
    ZERO_VALUE(0),
    LOTTO_NUMBER_COUNT(6),
    PERCENTAGE_FACTOR(100);
    private final int number;

    Constants(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
