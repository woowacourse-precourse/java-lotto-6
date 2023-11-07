package lotto.common.exception;

public class PurchaseAmountException extends IllegalArgumentException {
    public PurchaseAmountException(PurchaseAmountErrorMessage errorMessage) {
        super(errorMessage.getErrorMessage());
    }
}
