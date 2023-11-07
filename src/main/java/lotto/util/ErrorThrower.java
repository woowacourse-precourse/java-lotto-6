package lotto.util;

public class ErrorThrower {
    public static void throwIllegalArgumentException(String message) {
        throw new IllegalArgumentException(message);
    }

    public static void throwIllegalStateException(String message) {
        throw new IllegalStateException(message);
    }
}
