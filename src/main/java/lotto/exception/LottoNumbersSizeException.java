package lotto.exception;

import lotto.constants.ErrorMessage;

public class LottoNumbersSizeException extends IllegalStateException {

    public LottoNumbersSizeException() {
        super(ErrorMessage.LOTTO_NUMBER_SIZE_ERROR.getMessage());
    }
}
