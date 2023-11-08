package lotto.view.exception;


public class InvalidStringSplitException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "[ERROR] 문자열을 나눌수 없음";

    public InvalidStringSplitException() {
        super(ERROR_MESSAGE);
    }
}
