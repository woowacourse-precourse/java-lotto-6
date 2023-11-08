package lotto.exception;

public class NumberOutOfRangeException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호는 1 ~ 45 사이의 숫자만 가능합니다.";
    public NumberOutOfRangeException() {
        super(ERROR_MESSAGE);
    }
}