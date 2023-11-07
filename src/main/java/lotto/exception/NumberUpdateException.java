package lotto.exception;

import lotto.constants.message.ErrorMessage;

public class NumberUpdateException extends IllegalStateException {
    public NumberUpdateException() {
        super(ErrorMessage.NUMBER_UPDATE_ERROR.getMessage());
    }
}
