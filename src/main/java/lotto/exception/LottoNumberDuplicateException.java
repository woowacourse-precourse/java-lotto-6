package lotto.exception;

import lotto.constants.ErrorMessage;

public class LottoNumberDuplicateException extends IllegalStateException{
    public LottoNumberDuplicateException() {
        super(ErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR.getMessage());
    }
}
