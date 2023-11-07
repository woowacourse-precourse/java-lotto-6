package lotto.exception;

public class InvalidSeparatorException extends IllegalArgumentException {
    public static final InvalidSeparatorException invalidSeparatorException = new InvalidSeparatorException();

    private InvalidSeparatorException() {
        super("[ERROR] 쉼표를 잘못사용하였습니다.");
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
