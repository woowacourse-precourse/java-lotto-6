package lotto.util;

import static lotto.util.ExceptionMessage.NOT_NUMERIC;

public class TypeConvertor {

    public static Integer stringToInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC.getMessage());
        }
    }
}
