package lotto.exception;

import lotto.exception.ErrorMessage.ErrorMessages;

public class NotDividedThousandException extends IllegalArgumentException {
    private static final String NOT_DIVIDED_THOUSAND_EXCEPTION =
            ErrorMessages.ERROR_MESSAGES.getMessage() + ErrorMessages.NOT_DIVIDED_THOUSAND_EXCEPTION_MESSAGE.getMessage();

    public NotDividedThousandException() {
        super(NOT_DIVIDED_THOUSAND_EXCEPTION);
    }
}
