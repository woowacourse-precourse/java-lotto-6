package lotto.common.exception;

public class LottoException extends IllegalArgumentException {
    public LottoException(LottoErrorMessage errorMessage) {
        super(errorMessage.getErrorMessage());
    }
}
