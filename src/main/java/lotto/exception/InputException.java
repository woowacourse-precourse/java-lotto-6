package lotto.exception;

public class InputException extends IllegalArgumentException {
    private InputException(ErrorMessage errorMessage) {
        super(errorMessage.getErrorMessage());
    }

    public static InputException from(ErrorMessage errorMessage) {
        return new InputException(errorMessage);
    }
}