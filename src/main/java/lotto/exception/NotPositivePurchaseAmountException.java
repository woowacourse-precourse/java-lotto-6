package lotto.exception;

public class NotPositivePurchaseAmountException extends NotPositiveValueException {
    public NotPositivePurchaseAmountException() {
        super("구입 금액");
    }
}
