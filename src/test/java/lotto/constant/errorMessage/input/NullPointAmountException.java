package lotto.constant.errorMessage.input;

import lotto.constant.errorMessage.ExceptionStatus;

public class NullPointAmountException extends NullPointerException {

    public NullPointAmountException(ExceptionStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
    }
}
