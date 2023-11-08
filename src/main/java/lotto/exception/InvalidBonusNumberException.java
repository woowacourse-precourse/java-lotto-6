package lotto.exception;

public class InvalidBonusNumberException extends UserInvalidInputException {
    public InvalidBonusNumberException(Throwable cause) {
        super(cause);
    }

    public InvalidBonusNumberException(String message, int invalidInput) {
        super(message, Integer.toString(invalidInput));
    }

    public InvalidBonusNumberException(String message, int invalidInput, Throwable cause) {
        super(message, Integer.toString(invalidInput), cause);
    }

    public InvalidBonusNumberException(String message, String invalidInput, Throwable cause) {
        super(message, invalidInput, cause);
    }
}
