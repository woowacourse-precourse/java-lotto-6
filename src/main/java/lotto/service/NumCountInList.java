package lotto.service;

import java.util.Collections;
import java.util.List;

public class NumCountInList {
    public static int countOccurrences(List<Integer> list, int target) {
        return Collections.frequency(list, target);
    }
}
