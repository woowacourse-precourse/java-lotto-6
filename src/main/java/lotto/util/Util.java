package lotto.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import lotto.Amount;
import lotto.manager.Exception;

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

    public static List<Integer> splitAndParseToIntList(String string) {
        String[] split = string.split(",", -1);

        for (String number : split) {
            if (!Util.isNumber(number)) {
                Exception.NOT_NUMBER.throwing();
            }
        }
        return Arrays.stream(split)
                .map(Integer::parseInt)
                .toList();
    }
}
