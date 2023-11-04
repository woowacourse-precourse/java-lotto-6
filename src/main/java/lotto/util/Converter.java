package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    public static List<Integer> stringToIntList(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
