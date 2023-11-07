package lotto.exception;

public class InvalidLottoRangeException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE_INVALID_RANGE = "[ERROR] 로또는 1에서 45사이 입니다.";

    public InvalidLottoRangeException() {
        super(ERROR_MESSAGE_INVALID_RANGE);
    }
}
