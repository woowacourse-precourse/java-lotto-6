package lotto.contents;

public enum ContentNumbers {
    LOTTO_PRICE(1000),
    LOTTO_MAX_NUMBER(45),
    LOTTO_MIN_NUMBER(1),
    LOTTO_NUMBERS_COUNT(6),
    ZERO(0),
    PERCENTAGE(100);

    private final int number;

    ContentNumbers(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}