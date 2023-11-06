package lotto.util;

public class StringUtil {
    private StringUtil() {
    }

    public static boolean isSpaceOrNull(String content) {
        return content.isBlank();
    }

    public static boolean isNull(String content) {
        return content == null;
    }
}
