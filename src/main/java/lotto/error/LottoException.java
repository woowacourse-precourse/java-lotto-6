package lotto.error;

public class LottoException extends RuntimeException{

    public LottoException(final ExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
    }
}
