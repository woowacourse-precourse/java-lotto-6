package lotto.utils;

import lotto.exception.ExceptionCode;

public class Converter {

    public static long toLong(String input) {
        try {
            return Long.parseLong(input);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    ExceptionCode.NUMBER_FORMAT.getDescription()
            );
        }
    }

    public static int toInt(String input) {
        try {
            return Integer.parseInt(input);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    ExceptionCode.NUMBER_FORMAT.getDescription()
            );
        }
    }
}
