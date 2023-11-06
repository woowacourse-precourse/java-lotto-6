package lotto.exception;

import lotto.exception.constant.ErrorMessage;

public class InvalidPriceTypeException extends IllegalArgumentException{
    public InvalidPriceTypeException() {
        super(ErrorMessage.INVALID_PRICE_TYPE.getErrorMessage());
        LottoException.printErrorMessage(ErrorMessage.INVALID_PRICE_TYPE.getErrorMessage());
    }
}
