package lotto.exception;

public class LottoException extends IllegalArgumentException {
    public LottoException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage.getMessage());
    }
}
