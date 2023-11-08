package lotto.exception;

public class BaseException extends Exception{
    private static final String prefix = "[ERROR] ";

    public BaseException(ExceptionStatus status) {
        super(status.getMessage());
    }

    @Override
    public String getMessage() {
        return BaseException.prefix + super.getMessage();
    }
}
