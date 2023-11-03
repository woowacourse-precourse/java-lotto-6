package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringChanger {
    private StringChanger() {
    }

    public static String trimString(String input) {
        return input.trim();
    }

    public static List<String> stringToTrimmedStringList(String input) {
        return Arrays.stream(input.split(",", -1)).map(String::trim).collect(Collectors.toList());
    }

    public static int stringToInteger(String input) {
        return Integer.parseInt(input);
    }
}
