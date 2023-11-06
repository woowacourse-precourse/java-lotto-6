package lotto.constant.errorMessage.amount;

import lotto.constant.errorMessage.ExceptionStatus;

public class InvalidAmountException extends IllegalArgumentException {

    public InvalidAmountException(ExceptionStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
    }
}
