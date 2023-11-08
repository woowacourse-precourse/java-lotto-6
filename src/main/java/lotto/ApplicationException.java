package lotto;

public class ApplicationException extends IllegalArgumentException {
    ExceptionMessage message;

    public ApplicationException(ExceptionMessage exceptionMessage) {
        message = exceptionMessage;
    }
}
