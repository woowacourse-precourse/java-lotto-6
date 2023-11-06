package lotto.exception;

public class LottoException extends IllegalArgumentException {
    private LottoException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }

    public static LottoException of(ErrorMessage errorMessage) {
        return new LottoException(errorMessage);
    }
}
