package lotto.exception;

import lotto.constants.message.ErrorMessage;

public class LottoNumberDuplicateException extends IllegalArgumentException {
    public LottoNumberDuplicateException() {
        super(ErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR.getMessage());
    }
}
