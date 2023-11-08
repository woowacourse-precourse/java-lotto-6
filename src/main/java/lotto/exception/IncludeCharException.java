package lotto.exception;

public class IncludeCharException extends IllegalArgumentException {
    public static final IncludeCharException includeCharException = new IncludeCharException();

    private IncludeCharException() {
        super("[ERROR] 문자가 포함되어 있습니다.");
    }


    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
