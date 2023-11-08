package lotto.util;

import java.util.Arrays;
import java.util.List;

public class StringUtil {

    private static final String DELIMITER = ",";

    private StringUtil() {}

    public static List<Integer> convertToNumbers(String input) {
        return Arrays.stream(splitByDelimiter(removeWhiteSpace(input), DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }

    public static int convertToNumber(String input) {
        return Integer.parseInt(removeWhiteSpace(input));
    }

    public static String[] splitByDelimiter(String input, String delimiter) {
        return input.split(delimiter);
    }

    public static String removeWhiteSpace(String input) {
        return input.replaceAll("\\s", "");
    }
}
