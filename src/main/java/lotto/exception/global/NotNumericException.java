package lotto.exception.global;

import lotto.constants.message.ErrorMessage;

public class NotNumericException extends IllegalArgumentException {
    public NotNumericException() {
        super(ErrorMessage.NOT_NUMERIC_ERROR.getMessage());
    }
}
