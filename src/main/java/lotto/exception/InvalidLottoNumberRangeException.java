package lotto.exception;

public class InvalidLottoNumberRangeException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 로또 숫자는 1 ~ 45 범위만 가능합니다.";

    public InvalidLottoNumberRangeException() {
        super(ERROR_MESSAGE);
    }
}
