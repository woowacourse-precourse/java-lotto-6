package lotto.exception;

import lotto.exception.constant.ErrorMessage;

public class InvalidLottoFormatException extends IllegalArgumentException{
    public InvalidLottoFormatException() {
        super(ErrorMessage.INVALID_LOTTO_FORMAT.getErrorMessage());
        LottoException.printErrorMessage(ErrorMessage.INVALID_LOTTO_FORMAT.getErrorMessage());
    }
}
