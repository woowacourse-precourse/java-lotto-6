package lotto.exception;

public class InvalidNumberScopeException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "로또 숫자는 1에서부터 45사이 값 입니다.";

    public InvalidNumberScopeException() {
        super(ERROR_MESSAGE);
    }
}
