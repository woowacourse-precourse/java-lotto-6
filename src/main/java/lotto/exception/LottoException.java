package lotto.exception;

public class LottoException extends IllegalArgumentException {

    public LottoException(final ErrorCode errorCode) {
        super(errorCode.getMessage());
    }

}