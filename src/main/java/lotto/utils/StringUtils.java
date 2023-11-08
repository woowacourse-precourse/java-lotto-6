package lotto.utils;

public class StringUtils {
    public static void validEmptyString(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
