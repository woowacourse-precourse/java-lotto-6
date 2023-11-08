package lotto.service;

import java.util.Collections;
import java.util.List;

public class FindNumInListService {
    public static int countOccurrences(List<Integer> list, int target) {
        return Collections.frequency(list, target);
    }
}
