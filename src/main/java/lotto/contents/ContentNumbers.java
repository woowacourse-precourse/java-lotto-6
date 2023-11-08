package lotto.contents;

public enum ContentNumbers {
    LOTTO_PRICE(1_000),
    LOTTO_MAX_NUMBER(45),
    LOTTO_MIN_NUMBER(1),
    LOTTO_NUMBERS_COUNT(6),
    ZERO(0),
    PERCENTAGE(100),
    LOTTO_STRING_LENGTH(6),
    LOTTO_STRING_LENGTH_WINNING_NUMBER(17),
    LOTTO_BUY_MAX(100_000);

    private final int number;

    ContentNumbers(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}