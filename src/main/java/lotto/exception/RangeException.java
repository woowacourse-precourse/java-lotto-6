package lotto.exception;

public class RangeException extends IllegalArgumentException {
    public static final String RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    public RangeException() {
        super(RANGE_ERROR_MESSAGE);
    }
}
