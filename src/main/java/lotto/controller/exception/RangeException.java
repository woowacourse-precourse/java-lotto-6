package lotto.controller.exception;

public class RangeException extends IllegalArgumentException {
    private static final String MESSAGE = "[ERROR] 1이상 45이하의 숫자만 입력할 수 있습니다.";

    public RangeException() {
        super(MESSAGE);
    }
}
