package lotto.utils;

import lotto.utils.message.ErrorMessage;

public class StringUtils {
    public static int convertToInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER);
        }
    }
}
