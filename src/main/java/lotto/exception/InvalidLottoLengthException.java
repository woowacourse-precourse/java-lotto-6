package lotto.exception;

import lotto.exception.constant.ErrorMessage;

public class InvalidLottoLengthException extends IllegalArgumentException{
    public InvalidLottoLengthException() {
        super(ErrorMessage.INVALID_LOTTO_LENGTH.getErrorMessage());
        LottoException.printErrorMessage(ErrorMessage.INVALID_LOTTO_LENGTH.getErrorMessage());
    }
}
