package lotto.exception;

public class NumberRangeException extends IllegalArgumentException {
    public static final NumberRangeException numberRangeException = new NumberRangeException();

    private NumberRangeException() {
        super("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
