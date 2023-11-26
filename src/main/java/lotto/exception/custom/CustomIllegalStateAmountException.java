package lotto.exception.custom;

import lotto.exception.ExceptionStatus;

public class CustomIllegalStateAmountException extends IllegalStateException {

    public CustomIllegalStateAmountException(ExceptionStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
    }
}
