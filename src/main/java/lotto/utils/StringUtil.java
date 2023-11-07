package lotto.utils;

import lotto.constants.ErrorConstants;

public class StringUtil {

    public static void checkNotNull(String string) {
        if(! isNotNull(string)) {
            throw new IllegalArgumentException(ErrorConstants.PLEASE_ENTER_VALUE.getData());
        }
    }

    public static boolean isNotNull(String str) {
        return str != null && !str.isEmpty() && !str.isBlank();
    }
}
