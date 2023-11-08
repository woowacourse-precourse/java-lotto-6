package lotto.utils;

public class StringUtils {
    public static void validEmptyString(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validContainsWhiteSpace(String str) {
        if (str != null && str.contains(" ")) {
            throw new IllegalArgumentException();
        }
    }
}
