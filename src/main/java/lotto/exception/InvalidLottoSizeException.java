package lotto.exception;

public class InvalidLottoSizeException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE_INVALID_SIZE = "[ERROR] 로또는 6자리로 이루어져야 합니다.";

    public InvalidLottoSizeException() {
        super(ERROR_MESSAGE_INVALID_SIZE);
    }
}
