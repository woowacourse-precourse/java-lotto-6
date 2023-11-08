package lotto.view.exception;


public class InvalidZeroException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 입력 값이 0";

    public InvalidZeroException() {
        super(ERROR_MESSAGE);
    }

}