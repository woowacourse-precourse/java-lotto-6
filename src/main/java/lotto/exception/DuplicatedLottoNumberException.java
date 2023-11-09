package lotto.exception;

public class DuplicatedLottoNumberException extends IllegalArgumentException {
    public DuplicatedLottoNumberException() {
        super(ExceptionMessage.DUPLICATE_LOTTO_NUMBER_ERROR.getMessage());
    }
}
