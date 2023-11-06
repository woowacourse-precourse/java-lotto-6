package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.util.ExceptionMessage.NOT_NUMERIC;

public class TypeConvertor {

    private static final String REGEX = ",";

    public static Integer stringToInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC.getMessage());
        }
    }

    public static Long stringToLong(final String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC.getMessage());
        }
    }

    public static List<Integer> stringToStringList(final String input) {
        try {
            return Arrays.stream(input.split(REGEX))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC.getMessage());
        }
    }
}
