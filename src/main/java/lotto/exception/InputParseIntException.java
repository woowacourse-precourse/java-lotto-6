package lotto.exception;

public class InputParseIntException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 숫자가 아닌 값을 입력하였습니다.";

    public InputParseIntException() {
        super(ERROR_MESSAGE);
    }
}
