package lotto.utils;

import java.util.Arrays;
import java.util.List;

public class StringParser {
    private final static String REGEX = ",";

    public static List<String> splitString(String input) {
        return Arrays.stream(input.split(REGEX))
                .map(String::trim)
                .toList();
    }

    public static int parseStringToInt(String input) {
        return Integer.parseInt(input);
    }
}
