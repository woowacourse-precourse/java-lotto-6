package lotto.domain.exception.lottoException;

import lotto.view.ExceptionMessage;

public class LottoNumberRangeException extends IllegalArgumentException {

    public LottoNumberRangeException() {
        super(ExceptionMessage.LOTTO_RANGE_EXCEPTION.getErrorMessage());
    }
}
