package lotto.exception;

public class IllegalSizeException extends IllegalArgumentException {
    private static final String DEFAULT_MESSAGE = "로또 번호는 6자리 입니다.";

    public IllegalSizeException() {
        super(DEFAULT_MESSAGE);
    }
}
