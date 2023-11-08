package lotto.model.exceptions;

import static lotto.model.enums.ErrorMessage.INVALID_SIZE_MESSAGE;

public class InvalidSizeException extends IllegalArgumentException {
    public InvalidSizeException() {
        super(INVALID_SIZE_MESSAGE.getMessage());
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
