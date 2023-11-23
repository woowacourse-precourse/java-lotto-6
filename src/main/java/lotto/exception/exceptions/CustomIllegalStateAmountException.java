package lotto.exception.exceptions;

import lotto.exception.ExceptionStatus;

public class CustomIllegalStateAmountException extends IllegalStateException {

    public CustomIllegalStateAmountException(ExceptionStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
    }
}
