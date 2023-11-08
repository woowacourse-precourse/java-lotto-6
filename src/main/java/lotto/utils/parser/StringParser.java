package lotto.utils.parser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringParser {
    private final static String REGEX = ",";

    public static List<String> splitString(String input) {
        return Arrays.stream(input.split(REGEX))
                .map(String::trim)
                .toList();
    }

    public static List<Integer> parseStringToIntList(String input) {
        return Arrays.stream(input.split(REGEX))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    public static int parseStringToInt(String input) {
        return Integer.parseInt(input);
    }

    public static Set<Integer> parseListToSet(List<Integer> before) {
        return new HashSet<>(before);
    }
}
