package lotto.util;

import java.util.HashSet;
import java.util.List;
import lotto.Amount;

public class Util {
    public static boolean isNumber(String number) {
        try {
            new Amount(number);
            return true;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
    }

    public static boolean isWithinRange(List<Integer> numbers, int minNumber, int maxNumber) {
        long inRangeCount = numbers.stream()
                .filter((number) -> minNumber <= number && number <= maxNumber)
                .count();
        return inRangeCount == numbers.size();
    }

    public static boolean hasDuplicates(List<Integer> numbers) {
        HashSet<Integer> distinctNumbers = new HashSet<>(numbers);
        return distinctNumbers.size() != numbers.size();
    }

    public static boolean isEmptyOrBlank(String string) {
        if (string.isBlank()) {
            return true;
        }
        if (string.isEmpty()) {
            return true;
        }
        return false;
    }
}
