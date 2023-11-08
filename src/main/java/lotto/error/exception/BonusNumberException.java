package lotto.error.exception;

import lotto.error.ErrorCode;

public class BonusNumberException extends IllegalArgumentException {

    public BonusNumberException(final ErrorCode errorCode) {
        super(errorCode.getMessage());
    }

}