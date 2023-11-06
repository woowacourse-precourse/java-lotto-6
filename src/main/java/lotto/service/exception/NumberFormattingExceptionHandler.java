package lotto.service.exception;

public class NumberFormattingExceptionHandler extends NumberFormatException{
    private final InputErrorMessage exception;

    public NumberFormattingExceptionHandler(InputErrorMessage exception) {
        super(exception.getMessage());
        this.exception = exception;
    }

    public InputErrorMessage getException() {
        return exception;
    }
}
