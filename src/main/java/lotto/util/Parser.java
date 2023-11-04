package lotto.util;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public static List<String> parseString(String numbers) {
        return Arrays.stream(numbers.split(",", -1))
                .map(String::trim)
                .toList();
    }
}
