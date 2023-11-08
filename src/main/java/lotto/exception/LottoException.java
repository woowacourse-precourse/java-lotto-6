package lotto.exception;

public class LottoException extends IllegalArgumentException {
    private LottoException(String message) {
        super(message);
    }

    private LottoException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }

    public static LottoException from(ErrorMessage errorMessage) {
        return new LottoException(errorMessage);
    }

    public static LottoException from(String message) {
        return new LottoException(message);
    }
}
