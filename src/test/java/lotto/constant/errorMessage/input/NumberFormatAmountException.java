package lotto.constant.errorMessage.input;

import lotto.constant.errorMessage.ExceptionStatus;

public class NumberFormatAmountException extends NumberFormatException {

    public NumberFormatAmountException(ExceptionStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
    }
}
