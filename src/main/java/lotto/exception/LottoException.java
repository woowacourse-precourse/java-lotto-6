package lotto.exception;

public class LottoException extends IllegalArgumentException {
    public LottoException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage.getMessage());
    }

    public LottoException(ExceptionMessage exceptionMessage, Throwable cause) {
        super(exceptionMessage.getMessage(), cause);
    }
}
