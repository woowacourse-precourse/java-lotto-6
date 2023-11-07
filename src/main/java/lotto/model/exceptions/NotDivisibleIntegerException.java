package lotto.model.exceptions;

import static lotto.model.enums.ErrorMessage.NOT_DIVISIBLE_INTEGER_INPUT_MESSAGE;

public class NotDivisibleIntegerException extends IllegalArgumentException {
    public NotDivisibleIntegerException() {
        super(NOT_DIVISIBLE_INTEGER_INPUT_MESSAGE.getMessage());
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
