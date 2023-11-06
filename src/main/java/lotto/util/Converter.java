package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.exception.NonNumericInputException;

public class Converter {

    private static final String DELIMITER = ",";

    private Converter() {
    }

    public static List<Integer> convertStringToIntegerListByDelimiter(final String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(number -> getLottoNumber(number.trim()))
                .toList();
    }

    private static Integer getLottoNumber(final String number) {
        try {
            return Integer.valueOf(number);
        } catch (NumberFormatException e) {
            throw new NonNumericInputException();
        }
    }
}
