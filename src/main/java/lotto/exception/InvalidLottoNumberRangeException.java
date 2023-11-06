package lotto.exception;

import lotto.exception.constant.ErrorMessage;

public class InvalidLottoNumberRangeException extends IllegalArgumentException{
    public InvalidLottoNumberRangeException() {
        super(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getErrorMessage());
        LottoException.printErrorMessage(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getErrorMessage());
    }
}
