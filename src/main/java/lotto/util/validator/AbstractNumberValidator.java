package lotto.util.validator;

import lotto.constant.ErrorMessage;

public abstract class AbstractNumberValidator<T> implements InputValidator<T> {
    protected static final int MIN_WINNING_NUMBER = 1;
    protected static final int MAX_WINNING_NUMBER = 45;

    protected void validateNumberInRange(Integer number) {
        if (number < MIN_WINNING_NUMBER || number > MAX_WINNING_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_IS_NOT_VALID_RANGE);
        }
    }
}
