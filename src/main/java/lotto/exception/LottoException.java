package lotto.exception;

public class LottoException extends IllegalArgumentException {
    public LottoException(final String message) {
        super(message);
        System.out.println(message);
    }

    public static LottoException of(ErrorMessage errorMessage) {
        return new LottoException(errorMessage.getMessage());
    }
}
