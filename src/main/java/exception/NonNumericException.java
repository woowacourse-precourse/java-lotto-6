package exception;

public class NonNumericException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 숫자로 입력되어야 합니다!";

    public NonNumericException() {
        super(ERROR_MESSAGE);
    }
}
