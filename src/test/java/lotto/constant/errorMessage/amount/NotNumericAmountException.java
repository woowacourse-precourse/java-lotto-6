package lotto.constant.errorMessage.amount;

import lotto.constant.errorMessage.ExceptionStatus;

public class NotNumericAmountException extends NumberFormatException {

    public NotNumericAmountException(ExceptionStatus errorMessagesStatus) {
        super(errorMessagesStatus.getMessage());
    }
}
