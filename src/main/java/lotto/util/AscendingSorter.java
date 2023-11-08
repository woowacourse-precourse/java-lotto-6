package lotto.util;

import java.util.Collections;
import java.util.List;

public class AscendingSorter {
    public static List<Integer> sortAscending(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }
}
