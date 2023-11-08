package lotto.exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberCheck {
    private static final int start = 1;
    private static final int end = 45;
    public static boolean checkRange(int num)  {
        if ((num < start) || (num > end)) {
            return false;
        }
        return true;
    }

    public static boolean checkDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            return false;
        }
        return true;
    }

    public static boolean checkDuplicate(List<Integer> numbers, int bonus) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.contains(bonus)) {
            return false;
        }
        return true;
    }
}
