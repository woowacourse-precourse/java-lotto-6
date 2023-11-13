package lotto.exception;

public class AppException extends IllegalArgumentException {
    private static final String PREFIX = "[ERROR] ";

    public AppException(String message) {
        super(PREFIX + message);
    }

}
