package lotto.exception;

public class LottoException extends IllegalArgumentException {

    public LottoException(final LottoErrorCode errorCode) {
        super(errorCode.getMessage());
        System.out.println(errorCode.getMessage());
    }

}