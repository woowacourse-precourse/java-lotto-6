package lotto.constant.errorMessage.exception;

import lotto.constant.errorMessage.ExceptionStatus;

public class CustomIllegalStateAmountException extends IllegalStateException {

    public CustomIllegalStateAmountException(ExceptionStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
    }
}
