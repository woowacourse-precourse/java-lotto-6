package lotto.exception;

public class InvalidPurchasedAmountException extends UserInvalidInputException {
    InvalidPurchasedAmountException(String message, String invalidInput) {
        super(message, invalidInput);
    }

    public InvalidPurchasedAmountException(String message, String invalidInput, Throwable cause) {
        super(message, invalidInput, cause);
    }

    public InvalidPurchasedAmountException(String message, long invalidAmount) {
        super(message, Long.toString(invalidAmount));
    }

    public InvalidPurchasedAmountException(String message, long invalidAmount, Throwable cause) {
        super(message, Long.toString(invalidAmount), cause);
    }
}
