package lotto.util;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final String SPLIT_REGEX = ",";

    public static List<String> parseString(String numbers) {
        return Arrays.stream(numbers.split(SPLIT_REGEX))
                .map(String::trim)
                .toList();
    }
}
