package lotto.exception;

import lotto.constants.message.ErrorMessage;

public class NumberNullException extends IllegalStateException {
    public NumberNullException() {
        super(ErrorMessage.NUMBER_UPDATE_ERROR.getMessage());
    }
}
