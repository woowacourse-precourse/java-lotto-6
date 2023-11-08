package lotto.constant.errorMessage.exception;

import lotto.constant.errorMessage.ExceptionStatus;

public class CustomIllegalArgumentException extends IllegalArgumentException {

    public CustomIllegalArgumentException(ExceptionStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
    }
}
