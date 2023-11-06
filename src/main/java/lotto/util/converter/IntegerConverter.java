package lotto.util.converter;

import static lotto.util.message.ErrorMessages.NUMBER_FORMAT_EXCEPTION;

public class IntegerConverter {
    private IntegerConverter() {
    }

    public static int convert(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION);
        }
    }
}
