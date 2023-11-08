package lotto.exception;

public class LottoException extends IllegalArgumentException {
    public LottoException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }
}
