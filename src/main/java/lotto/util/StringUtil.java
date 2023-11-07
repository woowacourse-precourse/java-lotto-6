package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {
    public static List<Integer> convertToIntegerList(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}