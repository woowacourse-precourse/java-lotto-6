package lotto.service.exception;

public class HandleNumberFormattingException extends NumberFormatException{
    private final InputErrorMessage exception;

    public HandleNumberFormattingException(InputErrorMessage exception) {
        super(exception.getMessage());
        this.exception = exception;
    }

    public InputErrorMessage getException() {
        return exception;
    }
}
