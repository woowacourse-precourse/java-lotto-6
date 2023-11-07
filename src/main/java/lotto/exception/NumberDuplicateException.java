package lotto.exception;

public class NumberDuplicateException extends IllegalArgumentException {
    public static final NumberDuplicateException numberDuplicateException = new NumberDuplicateException();

    private NumberDuplicateException() {
        super("[ERROR] 중복된 숫자가 존재합니다.");
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
