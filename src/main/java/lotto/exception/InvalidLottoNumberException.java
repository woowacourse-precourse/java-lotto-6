package lotto.exception;

import lotto.constant.ErrorMessage;

public class InvalidLottoNumberException extends IllegalArgumentException {

    public InvalidLottoNumberException(ErrorMessage message) {
        super(message.getMessage());
    }
}
