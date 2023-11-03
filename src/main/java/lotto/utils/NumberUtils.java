package lotto.utils;

import java.util.List;
import java.util.stream.Collectors;

public class NumberUtils {
    public static List<Integer> sorted(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    public static List<String> convertToString(List<Integer> numbers) {
        return numbers.stream()
            .map(String::valueOf)
            .collect(Collectors.toList());
    }
}
