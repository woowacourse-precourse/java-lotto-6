package lotto.exception;

public class InvalidPurchasePriceException extends IllegalArgumentException {

    protected InvalidPurchasePriceException(String message) {
        super(message);
    }
}
