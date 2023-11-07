package utils;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public static List<Integer> stringToIntegerList(final String userInput) {
        return Arrays.stream(userInput.split(","))
                .map(Integer::parseInt)
                .toList();
    }
}
