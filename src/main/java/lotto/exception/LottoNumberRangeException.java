package lotto.exception;

import lotto.constants.ErrorMessage;

public class LottoNumberRangeException extends IllegalArgumentException {

    public LottoNumberRangeException() {
        super(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR.getMessage());
    }
}
