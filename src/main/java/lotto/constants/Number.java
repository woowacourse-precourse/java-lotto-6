package lotto.constants;

public enum Number {
    LOTTO_PRICE(1000),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    FIXED_LOTTO_NUMBERS_COUNT(6);

    private final int number;

    Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
