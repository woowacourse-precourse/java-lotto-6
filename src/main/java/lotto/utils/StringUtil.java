package lotto.utils;

public class StringUtil {

    public static boolean isNotNull(String str) {
        return str != null && !str.isEmpty() && !str.isBlank();
    }

    public static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
