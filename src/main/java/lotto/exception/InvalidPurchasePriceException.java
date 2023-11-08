package lotto.exception;

public class InvalidPurchasePriceException extends IllegalArgumentException {
    public InvalidPurchasePriceException(String s) {
        super(s);
    }

    public InvalidPurchasePriceException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidPurchasePriceException(Throwable cause) {
        super(cause);
    }
}
