package lotto.exception.exceptions;

import lotto.exception.ExceptionStatus;

public class CustomNumberFormatAmountException extends NumberFormatException {

    public CustomNumberFormatAmountException(ExceptionStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
    }
}
