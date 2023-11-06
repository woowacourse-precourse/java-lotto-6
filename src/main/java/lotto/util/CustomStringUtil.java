package lotto.util;

public class CustomStringUtil {
    private CustomStringUtil() {
    }

    public static boolean isSpaceOrNull(String content) {
        return content.isBlank();
    }

    public static boolean isNull(String content) {
        return content == null;
    }
}
