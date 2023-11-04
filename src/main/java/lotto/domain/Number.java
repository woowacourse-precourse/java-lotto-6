package lotto.domain;

import lotto.util.ValidationUtils;

public class Number {

    private final int MIN_NUMBER_RANGE = 1;
    private final int MAX_NUMBER_RANGE = 45;

    private final int number;

    public Number(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        ValidationUtils.validateNotNull(number);
        validateNumberInRange(number);
    }

    private void validateNumberInRange(int number) {
        if (number < MIN_NUMBER_RANGE || number > MAX_NUMBER_RANGE) {
            throw new IllegalArgumentException();
        }
    }
}
