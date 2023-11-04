package lotto.util;

import static lotto.util.message.Error.MUST_INTEGER;

public class Conversion {

    public static int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(MUST_INTEGER);
        }
    }
}
