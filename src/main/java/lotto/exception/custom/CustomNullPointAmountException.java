package lotto.exception.custom;

import lotto.exception.ExceptionStatus;

public class CustomNullPointAmountException extends NullPointerException {

    public CustomNullPointAmountException(ExceptionStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
    }
}
