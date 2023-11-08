package lotto.constant.errorMessage.input;

import lotto.constant.errorMessage.ExceptionStatus;

public class IllegalStateAmountException extends IllegalStateException {

    public IllegalStateAmountException(ExceptionStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
    }
}
