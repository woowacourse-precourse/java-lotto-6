package lotto.utils;

import java.util.Arrays;
import java.util.List;

public final class StringSplitParser {

    private static final String COMMA = ",";

    private StringSplitParser() {
    }

    public static List<String> splitStringToNumbers(String numbers) {
        return Arrays
                .stream(numbers.split(COMMA))
                .toList();
    }
}
