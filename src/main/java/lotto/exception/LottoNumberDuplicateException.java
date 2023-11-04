package lotto.exception;

import lotto.constants.ErrorMessage;

public class LottoNumberDuplicateException extends IllegalArgumentException {
    public LottoNumberDuplicateException() {
        super(ErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR.getMessage());
    }
}
