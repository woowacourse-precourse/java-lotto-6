package lotto.exception;

import lotto.exception.ErrorMessage.ErrorMessages;

public class NotNumberException extends IllegalArgumentException {
    private static final String NOT_NUMBER_EXCEPTION_MESSAGE =
            ErrorMessages.ERROR_MESSAGES.getMessage() + ErrorMessages.NOT_NUMBER_EXCEPTION_MESSAGE.getMessage();

    public NotNumberException() {
        super(NOT_NUMBER_EXCEPTION_MESSAGE);
    }
}
