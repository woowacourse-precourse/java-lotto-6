package lotto.Util;

public class ExceptionMessageFormatter {
    private static final String EXCEPTION_FORMAT = "[ERROR] ";

    public static String makeMessage(String message) {
        return EXCEPTION_FORMAT + message;
    }
}
