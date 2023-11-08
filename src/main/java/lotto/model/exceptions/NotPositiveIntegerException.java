package lotto.model.exceptions;

import static lotto.model.enums.ErrorMessage.NOT_POSITIVE_INTEGER_INPUT_MESSAGE;

public class NotPositiveIntegerException extends IllegalArgumentException {
    public NotPositiveIntegerException() {
        super(NOT_POSITIVE_INTEGER_INPUT_MESSAGE.getMessage());
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
