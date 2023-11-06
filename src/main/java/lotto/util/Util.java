package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class Util {
    private static final Pattern REGEX_BLANK = Pattern.compile("\\s");
    private static final String DIGIT_COMMA = ",";
    private static final String DIGIT_NONE = "";

    public static int convertStringToInt(String input) {
        try {
            int convert = Integer.parseInt(input);
            return convert;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_FORMAT.getMessage());
        }
    }

    public static List<Integer> splitNumberByComma(String numbers) {
        return Arrays
                .stream(removeSpaceAll(numbers).split(DIGIT_COMMA))
                .map(Integer::parseInt)
                .toList();
    }

    public static String removeSpaceAll(String numbers) {
        return numbers.replaceAll(String.valueOf(REGEX_BLANK), DIGIT_NONE);
    }

    public static boolean isEqual(int numA, int numB) {
        return Objects.equals(numA, numB);
    }
}
