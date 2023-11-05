package lotto.exception;

public class InvalidInputException extends IllegalArgumentException {
    private static final String INVALID_INPUT_MESSAGE = "[ERROR] 금액에는 정수를 입력해주세요.";
    public InvalidInputException() {
        super(INVALID_INPUT_MESSAGE);
    }
}
