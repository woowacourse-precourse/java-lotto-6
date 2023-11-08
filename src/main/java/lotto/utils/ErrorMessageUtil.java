package lotto.utils;

public class ErrorMessageUtil {
    private static final String PREFIX = "[ERROR] ";

    private ErrorMessageUtil() {
    }

    public static String getOutputErrorMessage(final IllegalArgumentException exception) {
        StringBuilder sb = new StringBuilder(PREFIX);
        sb.append(exception.getMessage()).append("\n");

        return sb.toString();
    }
}
