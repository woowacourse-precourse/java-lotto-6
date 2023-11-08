package lotto.exception;

public class LottoException extends IllegalArgumentException {

    private final ErrorType exceptionType;

    public LottoException(ErrorType exceptionType) {
        super(exceptionType.getMessage());
        this.exceptionType = exceptionType;
    }

    public ErrorType getExceptionType() {
        return exceptionType;
    }
}
