package lotto;

public class InvalidPurchasedAmountException extends UserInvalidInputException {
    InvalidPurchasedAmountException(String message, String invalidInput) {
        super(message, invalidInput);
    }

    InvalidPurchasedAmountException(String message, String invalidInput, Throwable cause) {
        super(message, invalidInput, cause);
    }

    InvalidPurchasedAmountException(String message, long invalidAmount) {
        super(message, Long.toString(invalidAmount));
    }

    InvalidPurchasedAmountException(String message, long invalidAmount, Throwable cause) {
        super(message, Long.toString(invalidAmount), cause);
    }
}
