package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {

    private static final int minimumLottoNumber = 1;
    private static final int maximumLottoNumber = 45;
    private static final int lottoNumberCount = 6;

    public static boolean isNumericValue(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        if (input.length() != 1 && input.charAt(0) == '-') {
            input = input.substring(1);
        }
        return input.chars().allMatch(Character::isDigit);
    }

    public static boolean hasCorrectRange(int number) {
        return number >= minimumLottoNumber && number <= maximumLottoNumber;
    }

    public static boolean hasCorrectRange(List<Integer> numbers) {
        return numbers.stream().allMatch(Validation::hasCorrectRange);
    }

    public static boolean hasCorrectSize(List<Integer> numbers) {
        return numbers.size() == lottoNumberCount;
    }

    public static boolean isPositive(int value) {
        return value > 0;
    }

    public static boolean hasDuplicate(List<Integer> numbers) {
        Set<Integer> numbersWithoutDuplicate = new HashSet<>(numbers);

        return numbersWithoutDuplicate.size() != numbers.size();
    }
}
