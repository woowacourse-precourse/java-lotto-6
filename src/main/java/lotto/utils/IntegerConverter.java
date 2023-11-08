package lotto.utils;

import static lotto.utils.ErrorMessages.NOT_INTEGER_TYPE;

public class IntegerConverter {
    private IntegerConverter() {

    }

    public static Integer convert(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER_TYPE);
        }
    }
}
