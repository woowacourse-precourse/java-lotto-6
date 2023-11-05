package lotto.service.exception;

public class HandleIllegalArgumentException extends IllegalArgumentException {

    private final InputErrorMessage exception;

    public HandleIllegalArgumentException(InputErrorMessage exception) {
        super(exception.getMessage());
        this.exception = exception;
    }

    public InputErrorMessage getException(){
        return exception;
    }
}
