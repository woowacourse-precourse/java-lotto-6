package lotto.exception;

public class EmptyStringException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "값을 입력하지 않았습니다.";

    public EmptyStringException() {
        super(ERROR_MESSAGE);
    }
}
