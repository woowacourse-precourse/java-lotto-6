package lotto.exception;

import lotto.exception.constant.ErrorMessage;

public class InvalidPriceRangeException extends IllegalArgumentException{
    public InvalidPriceRangeException() {
        super(ErrorMessage.INVALID_PRICE_RANGE.getErrorMessage());
        LottoException.printErrorMessage(ErrorMessage.INVALID_PRICE_RANGE.getErrorMessage());
    }
}
