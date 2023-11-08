package lotto.exception;

public class NotNumberException extends IllegalArgumentException {
    private static final String MESSAGE = "[ERROR] 숫자를 입력해 주세요.";

    public NotNumberException() {
        super(MESSAGE);
    }
}
