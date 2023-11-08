package lotto.exception;

public class DuplicateException extends IllegalArgumentException {
    private static final String MESSAGE = "중복되지 않은 6개의 숫자를 입력해 주세요.";

    public DuplicateException() {
        super(MESSAGE);
    }
}
