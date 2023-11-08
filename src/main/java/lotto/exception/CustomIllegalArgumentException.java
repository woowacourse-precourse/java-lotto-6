package lotto.exception;

public class CustomIllegalArgumentException extends IllegalArgumentException {
    public CustomIllegalArgumentException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage.getErrorMessage());
    }
}
