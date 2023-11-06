package lotto.exception;

import lotto.exception.constant.ErrorMessage;

public class EmptyException extends IllegalArgumentException{
    public EmptyException() {
        super(ErrorMessage.EMPTY.getErrorMessage());
        LottoException.printErrorMessage(ErrorMessage.EMPTY.getErrorMessage());
    }
}
