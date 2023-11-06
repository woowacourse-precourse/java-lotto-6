package lotto.util;

import java.util.List;

public class Converter {
    public static List<Integer> convertToInt(List<String> input) {
        return input.stream()
                .map(value -> Integer.parseInt(value))
                .toList();
    }
}
