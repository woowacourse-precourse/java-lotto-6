package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringChanger {
    private static final String SEPARATOR_BETWEEN_NUMBERS = ",";
    private static final int INCLUDING_LAST_BLANK = -1;

    private StringChanger() {
    }

    public static String trimString(String input) {
        return input.trim();
    }

    public static List<String> stringToTrimmedStringList(String input) {
        return Arrays.stream(
                        input.split(SEPARATOR_BETWEEN_NUMBERS, INCLUDING_LAST_BLANK))
                .map(String::trim).collect(Collectors.toList()
                );
    }

    public static int stringToInteger(String input) {
        return Integer.parseInt(input);
    }
}
