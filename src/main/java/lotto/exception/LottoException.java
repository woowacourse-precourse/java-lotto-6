package lotto.exception;

public class LottoException extends IllegalArgumentException {
    private ExceptionCode exceptionCode;

    public LottoException(String message, ExceptionCode exceptionCode) {
        super(message);
        this.exceptionCode = exceptionCode;
    }

    public LottoException(ExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
        this.exceptionCode = exceptionCode;
    }

    public ExceptionCode getCode() {
        return this.exceptionCode;
    }
}
