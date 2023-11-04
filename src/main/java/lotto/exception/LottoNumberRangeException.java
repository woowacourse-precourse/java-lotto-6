package lotto.exception;

import lotto.constants.ErrorMessage;

public class LottoNumberRangeException extends IllegalStateException{

    public LottoNumberRangeException() {
        super(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR.getMessage());
    }
}
