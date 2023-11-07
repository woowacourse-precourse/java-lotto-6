package lotto.constant.errorMessage.amount;

import lotto.constant.errorMessage.ExceptionStatus;

public class NumberFormatAmountException extends NumberFormatException {

    public NumberFormatAmountException(ExceptionStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
    }
}
