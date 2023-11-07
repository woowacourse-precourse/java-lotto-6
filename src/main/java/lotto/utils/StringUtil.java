package lotto.utils;

import lotto.constants.ErrorConstants;

public class StringUtil {

    public static void checkNotNull(String string) {
        if(! isNotNull(string)) {
            throw new IllegalArgumentException(ErrorConstants.PLEASE_ENTER_VALUE.getData());
        }
    }

    public static void checkNumeric(String string) {
        if(!isNumeric(string)) {
            throw new IllegalArgumentException(ErrorConstants.ONLY_ENTER_NUMBERS.getData());
        }
    }

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
