package lotto.utils;

import java.util.Arrays;
import java.util.List;

public final class StringUtils {
    private static final String DELIMITER = ",";

    private StringUtils() {
    }

    public static String[] split(String input) {
        return input.split(DELIMITER);
    }

    public static List<Integer> toIntegerList(String input) {
        return Arrays.stream(split(input))
                .map(Integer::parseInt)
                .toList();
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }

}
