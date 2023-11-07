package lotto.constants;

public enum NumberRule {
    LOTTO_PRICE(1000),
    MAX_AMOUNT(100_000),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    COUNT_OF_LOTTO_NUMBERS(6);

    private final int number;

    NumberRule(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
