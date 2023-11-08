package lotto.view.exception;

public class InvalidNumberException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 입력값이 숫자가 아님";

    public InvalidNumberException() {
        super(ERROR_MESSAGE);
    }

}
