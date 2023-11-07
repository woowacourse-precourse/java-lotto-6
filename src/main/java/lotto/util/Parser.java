package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    public static List<Integer> toIntegerList(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
