package lotto;

import static lotto.constant.ErrorMessage.NOT_NUMBER;

public class Converter {

    public static int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER);
        }
    }

}
