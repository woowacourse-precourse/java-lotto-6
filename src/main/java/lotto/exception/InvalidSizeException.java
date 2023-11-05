package lotto.exception;

public class InvalidSizeException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 총 6개의 번호를 입력해야 합니다.";
    public InvalidSizeException() {
        super(ERROR_MESSAGE);
    }
}