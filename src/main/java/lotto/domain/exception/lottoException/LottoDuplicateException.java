package lotto.domain.exception.lottoException;

import lotto.view.ExceptionMessage;

public class LottoDuplicateException extends IllegalArgumentException {

    public LottoDuplicateException() {
        super(ExceptionMessage.DUPLICATE_EXCEPTION.getErrorMessage());
    }
}
