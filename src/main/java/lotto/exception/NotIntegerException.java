package lotto.exception;

public class NotIntegerException extends RuntimeException {
    private static final String MESSAGE = "[ERROR] 숫자를 입력해 주세요.";

    public NotIntegerException() {
        super(MESSAGE);
    }
}
