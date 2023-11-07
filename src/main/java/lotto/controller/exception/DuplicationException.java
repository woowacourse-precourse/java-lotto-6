package lotto.controller.exception;

public class DuplicationException extends IllegalArgumentException {
    private static final String MESSAGE = "[ERROR] 중복되는 숫자는 입력할 수 없습니다.";

    public DuplicationException() {
        super(MESSAGE);
    }
}
