package lotto.model;

public enum Rule {

    MIN_NUMBER(1),
    MAX_NUMBER(45),
    LOTTO_NUMBERS_DIGITS(6),
    BONUS_NUMBER_DIGITS(1),
    LOTTO_PRICE(1000),
    MINIMUM_NUMBER_TO_WIN(3),
    FIFTH_RANK(3),
    FOURTH_RANK(4),
    THIRD_RANK(5),
    SECOND_RANK(20),
    FIRST_RANK(6);

    private final int value;

    Rule(int number) {
        this.value = number;
    }

    public int value() {
        return this.value;
    }
}
