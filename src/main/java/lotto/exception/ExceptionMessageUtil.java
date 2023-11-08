package lotto.exception;

public class ExceptionMessageUtil {
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    public static String getErrorMessage(String message) {
        return ERROR_MESSAGE_PREFIX + message;
    }
}
