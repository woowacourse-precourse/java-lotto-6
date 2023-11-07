package lotto.exception;

public class InvalidNumberFormatException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "숫자를 잘못 입력하셨습니다.";

    public InvalidNumberFormatException() {
        super(ERROR_MESSAGE);
    }
}
