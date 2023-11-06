package lotto.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CalculationUtils {

    public static boolean isNumberInRange(int number, int start, int end) {
        return number >= start && number <= end;
    }

    public static boolean hasDuplicates(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        return set.size() < list.size();
    }

}
