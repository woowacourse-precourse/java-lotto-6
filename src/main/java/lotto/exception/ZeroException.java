package lotto.exception;

public class ZeroException extends IllegalArgumentException{
    public static final String ZERO_ERROR_MESSAGE = "[ERROR] 구입 금액은 0보다 커야 합니다.";

    public ZeroException() {
        super(ZERO_ERROR_MESSAGE);
    }
}
