package lotto.exception;

import lotto.exception.constant.ErrorMessage;

public class InvalidInputException extends IllegalArgumentException{
    public InvalidInputException() {
        super(ErrorMessage.INVALID_INPUT.getErrorMessage());
        LottoException.printErrorMessage(ErrorMessage.INVALID_INPUT.getErrorMessage());
    }
}
