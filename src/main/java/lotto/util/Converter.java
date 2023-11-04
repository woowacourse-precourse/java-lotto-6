package lotto.util;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import lotto.exception.CanNotConvertToIntException;

public class Converter {

    private static final String COMMA = ",";

    public static int convertStringToInt(final String input) {
        validateConvertToInt(input);
        return Integer.parseInt(input);
    }

    private static void validateConvertToInt(final String input) {
        if (!canConvertToInt(input)) {
            throw new CanNotConvertToIntException(input);
        }
    }

    private static boolean canConvertToInt(final String input) {
        return input.chars()
                .allMatch(Character::isDigit);
    }

    public static List<Integer> splitWithCommaAndConvertToIntegerList(final String input) {
        String[] texts = input.split(COMMA);
        for (String text : texts) {
            validateConvertToInt(text);
        }
        return convertStringArrayToIntegerList(texts);
    }

    private static List<Integer> convertStringArrayToIntegerList(final String[] texts) {
        return Arrays.stream(texts)
                .map(Integer::parseInt)
                .toList();
    }

    public static String formatNumberWithComma(final int number) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(number);
    }
}
