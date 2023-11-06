package lotto.utils.constants;

public class ErrorConstants {
    private static final String ERROR_FORMAT = "[ERROR] %s";
    public static String formatError(String message) {
        return String.format(ERROR_FORMAT + "%n", message);
    }
}
