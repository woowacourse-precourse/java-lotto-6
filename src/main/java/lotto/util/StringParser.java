package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class StringParser {

    private StringParser() {
    }

    public static List<Integer> split(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
