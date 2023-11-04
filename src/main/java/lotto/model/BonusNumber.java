package lotto.model;

import static lotto.util.Constant.START_INCLUSIVE;
import static lotto.util.Constant.END_INCLUSIVE;

import lotto.exception.InvalidNumberException;

public class BonusNumber {

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
        return START_INCLUSIVE.getValue() <= number && number <= END_INCLUSIVE.getValue();
    }

    public int getNumber() {
        return number;
    }
}
