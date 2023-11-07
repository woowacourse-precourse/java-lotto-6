package lotto.utils;

public class ErrorMessageUtil {
    private static final String PREFIX = "[ERROR] ";

    private ErrorMessageUtil() {
    }

    public static String getOutputErrorMessage(String errorMessage) {
        StringBuilder sb = new StringBuilder(PREFIX);
        sb.append(errorMessage).append("\n");

        return sb.toString();
    }
}
