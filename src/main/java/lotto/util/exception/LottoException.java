package lotto.util.exception;

public class LottoException extends IllegalArgumentException {
    private LottoException(final ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }

    public static LottoException of(final ErrorMessage errorMessage) {
        return new LottoException(errorMessage);
    }
}
