package lotto.exception;

public class InvalidTypeException extends IllegalArgumentException {

    private InvalidTypeException(final ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }

    public static InvalidTypeException from(final ErrorMessage errorMessage) {
        return new InvalidTypeException(errorMessage);
    }
}
