package lotto.util;

public class Util {
    public static boolean isNumber(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
    }
}
