package lotto.exception;

public class IllegalRangeException extends IllegalArgumentException {
    private static final String DEFAULT_MESSAGE = "번호의 값은 1 ~ 45 사이의 정수 입니다.";

    public IllegalRangeException() {
        super(DEFAULT_MESSAGE);
    }
}
