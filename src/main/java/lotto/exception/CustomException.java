package lotto.exception;

public abstract class CustomException extends IllegalArgumentException {
    private static final String ERROR = "[ERROR] ";
    public CustomException(String exceptionMessage) {
        super(ERROR + exceptionMessage);
    }
}
