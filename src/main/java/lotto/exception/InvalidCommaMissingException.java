package lotto.exception;

public class InvalidCommaMissingException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 쉼표가 없습니다.";

    public InvalidCommaMissingException() {
        super(ERROR_MESSAGE);
    }
}
