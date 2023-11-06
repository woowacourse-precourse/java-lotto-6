package lotto.exception;

public class InvalidLottoNumberException extends IllegalArgumentException {

    private static final String INVALID_LOTTO_NUMBER__MESSAGE = "[ERROR] 올바른 로또 숫자가 아닙니다.";

    public InvalidLottoNumberException() {
        super(INVALID_LOTTO_NUMBER__MESSAGE);
    }
}
