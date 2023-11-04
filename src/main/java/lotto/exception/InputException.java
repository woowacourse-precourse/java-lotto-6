package lotto.exception;

public class InputException extends IllegalArgumentException {
    private ExceptionCode exceptionCode;

    public InputException(String message, ExceptionCode exceptionCode) {
        super(message);
        this.exceptionCode = exceptionCode;
    }

    public InputException(ExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
        this.exceptionCode = exceptionCode;
    }

    public ExceptionCode getCode() {
        return this.exceptionCode;
    }
}
