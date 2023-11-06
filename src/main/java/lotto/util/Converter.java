package lotto.util;

import static lotto.enums.Delimiter.COMMA;
import static lotto.enums.ErrorMassage.INVALID_NUMBER;
import static lotto.enums.ErrorMassage.NOT_SEPARATE_BY_DELIMITER;

import java.util.Arrays;
import java.util.List;

public class Converter {
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
}
