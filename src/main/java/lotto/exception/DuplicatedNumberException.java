package lotto.exception;

import lotto.exception.constant.ErrorMessage;

public class DuplicatedNumberException extends IllegalArgumentException{
    public DuplicatedNumberException() {
        super(ErrorMessage.DUPLICATED_NUMBER.getErrorMessage());
        LottoException.printErrorMessage(ErrorMessage.DUPLICATED_NUMBER.getErrorMessage());
    }
}
