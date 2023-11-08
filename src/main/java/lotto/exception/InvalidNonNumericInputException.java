package lotto.exception;

public class InvalidNonNumericInputException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 숫자만 입력해 주세요.";

    public InvalidNonNumericInputException() {
        super(ERROR_MESSAGE);
    }
}
