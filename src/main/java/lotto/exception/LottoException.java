package lotto.exception;

public class LottoException extends IllegalArgumentException {
    private LottoException(
            ErrorMessage errorMessage,
            Exception exception
    ) {
        super(errorMessage.getMessage(), exception);
    }

    private LottoException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }

    public static LottoException of(
            ErrorMessage errorMessage,
            Exception exception
    ) {
        return new LottoException(errorMessage, exception);
    }

    public static LottoException from(ErrorMessage errorMessage) {
        return new LottoException(errorMessage);
    }
}
