package lotto.constant.errorMessage.input;

import lotto.constant.errorMessage.ExceptionStatus;

public class IllegalArgumentAmountException extends IllegalArgumentException {

    public IllegalArgumentAmountException(ExceptionStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
    }
}
