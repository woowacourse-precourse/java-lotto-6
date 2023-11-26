package lotto.exception.custom;

import lotto.exception.ExceptionStatus;

public class CustomIllegalArgumentException extends IllegalArgumentException {

    public CustomIllegalArgumentException(final ExceptionStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
    }
}
