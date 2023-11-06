package lotto.Util;

public class ExceptionMessageFormatter {
    private static String EXCEPTION_FORMAT = "[ERROR] ";

    public static String makeMessage(String message) {
        return EXCEPTION_FORMAT + message;
    }
}
