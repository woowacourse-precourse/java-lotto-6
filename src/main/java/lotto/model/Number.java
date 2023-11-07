package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Number {
    private static final int start = 1;
    private static final int end = 45;

    public static void checkRange(int num) throws IllegalArgumentException {
        if ((num < start) || (num > end)) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean checkDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            return false;
        }
        return true;
    }

    public static void checkDuplicate(List<Integer> numbers, int bonus) throws IllegalArgumentException{
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.contains(bonus)) {
            throw new IllegalArgumentException();
        }
    }

}
