package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringUtil {
    public static List<Integer> convertToIntegerList(String input, String delimiter) {
        return splitInput(input, delimiter)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static Stream<String> splitInput(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter));
    }
}