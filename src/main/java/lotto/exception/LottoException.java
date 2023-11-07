package lotto.exception;

public class LottoException extends IllegalArgumentException {

    private LottoException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }

    private LottoException(ErrorMessage errorMessage, Throwable cause) {
        super(errorMessage.getMessage(), cause);
    }

    public static LottoException from(ErrorMessage errorMessage) {
        return new LottoException(errorMessage);
    }

    public static LottoException of(ErrorMessage errorMessage, Throwable cause) {
        return new LottoException(errorMessage, cause);
    }
}
