package lotto.common.exception;

public class LottoNumberException extends IllegalArgumentException {
    public LottoNumberException(LottoNumberErrorMessage errorMessage) {
        super(errorMessage.getErrorMessage());
    }
}
