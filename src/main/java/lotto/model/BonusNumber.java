package lotto.model;

import lotto.exception.InvalidNumberException;

public class BonusNumber {

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;


    private final int number;

    public BonusNumber(final int number) {
        validateNumberInRange(number);
        this.number = number;
    }

    private void validateNumberInRange(final int number) {
        if (!isValidNumber(number)) {
            throw new InvalidNumberException(number);
        }
    }

    private boolean isValidNumber(final int number) {
        return START_INCLUSIVE <= number && number <= END_INCLUSIVE;
    }

    public int getNumber() {
        return number;
    }
}
