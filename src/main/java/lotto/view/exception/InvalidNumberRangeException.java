package lotto.view.exception;

public class InvalidNumberRangeException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "[ERROR] 숫자가 1~45 사이의 값이 아님";

    public InvalidNumberRangeException() {
        super(ERROR_MESSAGE);
    }
}
