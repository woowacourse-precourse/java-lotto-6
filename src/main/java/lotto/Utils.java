package lotto;

import static lotto.exception.ExceptionMessage.NOT_NUMBER;

public class Utils {

    public static int convertStringToInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER.getMessage());
        }
    }
}
