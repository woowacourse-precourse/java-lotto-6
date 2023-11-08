package lotto.domain.exception;

import lotto.view.ExceptionMessage;

public class PurchaseNotAvailableException extends IllegalArgumentException {

    public PurchaseNotAvailableException() {
        super(ExceptionMessage.PURCHASE_NOT_AVAILABLE_EXCEPTION.getErrorMessage());
    }
}
