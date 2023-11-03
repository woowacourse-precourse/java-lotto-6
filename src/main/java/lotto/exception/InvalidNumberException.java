package lotto.exception;

public class InvalidNumberException extends IllegalArgumentException {

    public static final String INVALID_NUMBER = "번호는 1 이상 45 이하여야 합니다.";

    public InvalidNumberException() {
        super(INVALID_NUMBER);
    }

    public InvalidNumberException(String s) {
        super(s);
    }
}
