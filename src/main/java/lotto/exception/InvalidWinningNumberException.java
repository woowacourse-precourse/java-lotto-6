package lotto.exception;

import lotto.constant.ErrorMessage;

public class InvalidWinningNumberException extends IllegalArgumentException {

    public InvalidWinningNumberException(ErrorMessage message) {
        super(message.getMessage());
    }
}
