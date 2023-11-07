package lotto.exception;

public class BlankException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 빈 값은 입력할 수 없습니다.";

    public BlankException() {
        super(ERROR_MESSAGE);
    }
}
