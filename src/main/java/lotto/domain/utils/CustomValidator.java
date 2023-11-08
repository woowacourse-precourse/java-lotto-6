package lotto.domain.utils;

public final class CustomValidator {
    public static String formatException(String exceptionMessage) {
        return String.format("[ERROR]%s", exceptionMessage);
    }

    public static void validate(boolean condition, String exceptionMessage) {
        if (condition) {
            throw new IllegalArgumentException(formatException(exceptionMessage));
        }
    }
}
