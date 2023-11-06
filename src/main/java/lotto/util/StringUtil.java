package lotto.util;

import static lotto.enums.ErrorMassage.INVALID_NUMBER;

public class StringUtil {
    public static int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER.getMassage());
        }
    }
}
