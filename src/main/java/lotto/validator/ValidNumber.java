package lotto.validator;

public enum ValidNumber {
    LOTTO_NUMBER_MIN_RANGE(1),
    LOTTO_NUMBER_MAX_RANGE(45),
    LOTTO_DIGIT_RESTRICTIONS(6),
    LOTTO_PRICE_UNIT(1000);

    private final int number;

    ValidNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
