package lotto.constant.errorMessage.amount;

import lotto.constant.errorMessage.ExceptionStatus;

public class IllegalStateAmountException extends IllegalStateException {

    public IllegalStateAmountException(ExceptionStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
    }
}
