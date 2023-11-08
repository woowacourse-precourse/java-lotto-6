package lotto.exception;

public class InvalidNumberException extends IllegalArgumentException {
    private static final String INPUT_NON_NUMBER = "[ERROR] 입력값이 숫자가 아닙니다.";

    public InvalidNumberException() {
        super(INPUT_NON_NUMBER);
    }
}
