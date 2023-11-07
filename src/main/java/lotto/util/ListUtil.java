package lotto.util;

import java.util.HashSet;
import java.util.List;

public class ListUtil {
    public static boolean isWithinRange(List<Integer> numbers, int startInclusive, int endInclusive) {
        long inRangeCount = numbers.stream()
                .filter((number) -> isInRange(number, startInclusive, endInclusive))
                .count();
        return inRangeCount == numbers.size();
    }

    public static boolean isInRange(int number, int startInclusive, int endInclusive) {
        return startInclusive <= number && number <= endInclusive;
    }

    public static boolean hasDuplicates(List<Integer> numbers) {
        HashSet<Integer> distinctNumbers = new HashSet<>(numbers);
        return distinctNumbers.size() != numbers.size();
    }
}
