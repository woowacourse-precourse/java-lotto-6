package lotto.utils;

import java.util.Arrays;
import java.util.List;

public final class StringUtils {
    private static final String DELIMITER = ",";

    private StringUtils() {
    }

    public static List<Integer> toIntegerList(String input) {
        try {
            return Arrays.stream(split(input))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS.getMessage());
        }
    }

    private static String[] split(String input) {
        return input.split(DELIMITER);
    }

    public static int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }

}
