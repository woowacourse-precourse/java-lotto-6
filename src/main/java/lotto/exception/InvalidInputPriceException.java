package lotto.exception;

import lotto.exception.constant.ErrorMessage;

public class InvalidInputPriceException extends IllegalArgumentException{
    public InvalidInputPriceException() {
        super(ErrorMessage.INVALID_INPUT_PRICE.getErrorMessage());
        LottoException.printErrorMessage(ErrorMessage.INVALID_INPUT_PRICE.getErrorMessage());
    }
}
