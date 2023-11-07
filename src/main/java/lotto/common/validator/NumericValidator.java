package lotto.common.validator;

import java.util.List;
import java.util.Set;

public class NumericValidator {

    private NumericValidator() {
    }

    public static void validatePositiveInteger(int number, String message) {
        if (!isPositive(number)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateDivisible(int dividend, int divisor, String message) {
        if (Math.floorMod(dividend, divisor) != 0) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateNotDuplicated(List<Integer> numbers, String message) {
        if (duplicatedExists(numbers)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateNumberSize(List<Integer> numbers, int size, String message) {
        if (numbers.size() != size) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateNumberRange(
            List<Integer> numbers,
            int startInclusive,
            int endInclusive,
            String message
    ) {
        if (!isInRange(numbers, startInclusive, endInclusive)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateNumberRange(
            int number,
            int startInclusive,
            int endInclusive,
            String message
    ) {
        if (!isInRange(number, startInclusive, endInclusive)) {
            throw new IllegalArgumentException(message);
        }
    }

    private static boolean duplicatedExists(List<Integer> numbers) {
        return Set.copyOf(numbers).size() != numbers.size();
    }

    private static boolean isInRange(List<Integer> numbers, int startInclusive, int endInclusive) {
        return numbers.stream()
                .allMatch(number -> number >= startInclusive && number <= endInclusive);
    }

    private static boolean isInRange(int number, int startInclusive, int endInclusive) {
        return number >= startInclusive && number <= endInclusive;
    }

    private static boolean isPositive(int number) {
        return number > 0;
    }

}
