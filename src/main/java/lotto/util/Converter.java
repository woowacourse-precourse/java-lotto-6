package lotto.util;

import static lotto.enums.Delimiter.COMMA;
import static lotto.enums.ErrorMessage.INVALID_NUMBER;
import static lotto.enums.ErrorMessage.NOT_SEPARATE_BY_DELIMITER;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class Converter {
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###,###");
    private static final int TEN = 10;
    private static final int DECIMAL_POINT = 1;

    private Converter() {
    }

    public static int convertToInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER.getMassage());
        }
    }

    public static List<Integer> convertToIntListByDelimiter(final String input) {
        if (!input.matches(COMMA.getRegex())) {
            throw new IllegalArgumentException(NOT_SEPARATE_BY_DELIMITER.getMassage());
        }
        return Arrays.stream(input.split(COMMA.getValue()))
                .map(Converter::convertToInt)
                .toList();
    }

    public static String convertNumberWithComma(final int number) {
        return DECIMAL_FORMAT.format(number);
    }

    public static String convertToStringWithRound(final double value) {
        double rounder = Math.pow(TEN, DECIMAL_POINT);
        return String.valueOf(Math.round(value * rounder) / rounder);
    }
}
