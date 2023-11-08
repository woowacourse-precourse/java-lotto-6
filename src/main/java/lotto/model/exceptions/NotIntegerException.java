package lotto.model.exceptions;

import static lotto.model.enums.ErrorMessage.NOT_INTEGER_INPUT_MESSAGE;

public class NotIntegerException extends IllegalArgumentException {
    public NotIntegerException() {
        super(NOT_INTEGER_INPUT_MESSAGE.getMessage());
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
