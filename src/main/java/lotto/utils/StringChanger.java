package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringChanger {
    private StringChanger() {
    }

    public static String trimString(String string) {
        return string.trim();
    }

    public static List<String> stringToTrimmedStringList(String userInput) {
        return Arrays.stream(userInput.split(",", -1)).map(String::trim).collect(Collectors.toList());
    }
}
