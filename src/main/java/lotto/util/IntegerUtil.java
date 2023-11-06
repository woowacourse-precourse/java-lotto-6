package lotto.util;

public class IntegerUtil {

    public static boolean checkNumberInRange(Integer number, Integer from, Integer to) {
        if (number == null || from == null || to == null) {
            throw new IllegalArgumentException();
        }

        if (number < from || number > to) {
            return false;
        }
        return true;
    }
}
