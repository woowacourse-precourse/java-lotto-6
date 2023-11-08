package lotto.service.exception;

public class IllegalArgumentExceptionHandler extends IllegalArgumentException {

    private final InputErrorMessage exception;

    public IllegalArgumentExceptionHandler(InputErrorMessage exception) {
        super(exception.getMessage());
        this.exception = exception;
    }

    public InputErrorMessage getException(){
        return exception;
    }
}
