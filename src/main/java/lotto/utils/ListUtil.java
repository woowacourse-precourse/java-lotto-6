package lotto.utils;

import java.util.List;

public class ListUtil {
    public static boolean checkDuplicateValue(List<Integer> numbers) {
        return numbers.stream().distinct().count() == numbers.size();
    }

    public static boolean checkLength(List<Integer> numbers) {
        return numbers.size() == 6;
    }

    public static boolean checkRange(List<Integer> numbers) {
        return numbers.stream().allMatch(num -> num >= 0 && num <= 46);
    }
}