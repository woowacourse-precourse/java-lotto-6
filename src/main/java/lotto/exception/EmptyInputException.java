package lotto.exception;

import lotto.exception.ErrorMessage.ErrorMessages;

public class EmptyInputException extends IllegalStateException {
    private static final String EmptyInputExceptionMessage =
            ErrorMessages.ERROR_MESSAGES.getMessage() + ErrorMessages.EMPTY_INPUT_EXCEPTION_MESSAGE.getMessage();

    public EmptyInputException() {
        super(EmptyInputExceptionMessage);
    }
}
