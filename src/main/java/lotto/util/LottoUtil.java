package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoUtil {
    public static void sortByAsc(List<Integer> numbers) {
        numbers.sort(null);
    }

    public static List<Integer> convert(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static String convertToDisplayFormat(List<Integer> numbers) {
        return "[" + numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")) + "]";
    }
}
