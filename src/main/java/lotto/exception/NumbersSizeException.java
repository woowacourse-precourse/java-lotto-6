package lotto.exception;

public class NumbersSizeException extends IllegalArgumentException {
    public static final NumbersSizeException numbersSizeException = new NumbersSizeException();

    private NumbersSizeException() {
        super("[ERROR] 로또 번호는 6자리 숫자여야 합니다.");
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
