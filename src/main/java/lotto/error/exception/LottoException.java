package lotto.error.exception;

import lotto.error.ErrorCode;

public class LottoException extends IllegalArgumentException {

    public LottoException(final ErrorCode errorCode) {
        super(errorCode.getMessage());
    }

}