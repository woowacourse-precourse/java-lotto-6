package lotto.exception;

public class NotNumberException extends IllegalArgumentException {
    private static final String MESSAGE = "숫자를 입력해 주세요.";

    public NotNumberException() {
        super(MESSAGE);
    }
}
