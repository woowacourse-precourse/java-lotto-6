package lotto.constant.errorMessage.exception;

import lotto.constant.errorMessage.ExceptionStatus;

public class CustomNumberFormatAmountException extends NumberFormatException {

    public CustomNumberFormatAmountException(ExceptionStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
    }
}
