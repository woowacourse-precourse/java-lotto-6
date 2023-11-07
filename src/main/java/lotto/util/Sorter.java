package lotto.util;

import java.util.List;
import java.util.stream.Collectors;

public class Sorter {
    public static List<Integer> sort(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }
}
