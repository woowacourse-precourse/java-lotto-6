package lotto.constant.errorMessage.exception;

import lotto.constant.errorMessage.ExceptionStatus;

public class CustomNullPointAmountException extends NullPointerException {

    public CustomNullPointAmountException(ExceptionStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
    }
}
