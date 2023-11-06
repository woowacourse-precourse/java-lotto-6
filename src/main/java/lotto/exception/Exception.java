package lotto.exception;

public class Exception extends IllegalArgumentException {
    private Exception(ErrorMessage errorMessage) {
        super(errorMessage.getErrorMessage());
    }

    public static Exception from(ErrorMessage errorMessage) {
        return new Exception(errorMessage);
    }
}