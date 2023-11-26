package lotto.exception.custom;

import lotto.exception.ExceptionStatus;

public class CustomNumberFormatAmountException extends NumberFormatException {

    public CustomNumberFormatAmountException(ExceptionStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
    }
}
