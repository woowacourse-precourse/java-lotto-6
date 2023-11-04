package lotto.utils;

public class StringUtils {

    private StringUtils() {
    }

    public static boolean isDigit(String s) {
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
