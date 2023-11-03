package lotto.exception;

public class InvalidSizeException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE_INVALID_SIZE = "[ERROR] 로또는 6자리로 이루어져야 합니다.";

    public InvalidSizeException() {
        super(ERROR_MESSAGE_INVALID_SIZE);
    }
}
