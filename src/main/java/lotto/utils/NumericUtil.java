package lotto.utils;

public class NumericUtil {
    public static boolean isNumeric(char c) {
        if (!Character.isDigit(c)) {
            return false;
        }
        return true;
    }
}
