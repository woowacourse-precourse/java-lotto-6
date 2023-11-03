package lotto.exception;

import lotto.constants.ErrorMessage;

public class NotNumericException extends IllegalArgumentException {
    public NotNumericException() {
        super(ErrorMessage.NOT_NUMERIC_ERROR.getMessage());
    }
}
