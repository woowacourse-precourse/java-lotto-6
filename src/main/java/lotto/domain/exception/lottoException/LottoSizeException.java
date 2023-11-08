package lotto.domain.exception.lottoException;

import lotto.view.ExceptionMessage;

public class LottoSizeException extends IllegalArgumentException {

    public LottoSizeException() {
        super(ExceptionMessage.LOTTO_SIZE_EXCEPTION.getErrorMessage());
    }
}
