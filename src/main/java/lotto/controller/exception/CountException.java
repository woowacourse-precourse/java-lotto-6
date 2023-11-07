package lotto.controller.exception;

public class CountException extends IllegalArgumentException {
    private static final String MESSAGE = "[ERROR] 6개의 숫자를 입력해야 합니다.";

    public CountException() {
        super(MESSAGE);
    }
}
