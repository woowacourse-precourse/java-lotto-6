package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {

    private static final int minimumLottoNumber = 1;
    private static final int maximumLottoNumber = 45;
    private static final int lottoNumberCount = 6;

    public static boolean isNumericValue(String input) {
        char[] data = input.toCharArray();
        int index = 0;

        if (data[index] == '-') {
            index++;
        }
        for (int i = index; i < data.length; i++) {
            if (!Character.isDigit(data[i])) {
                return false;
            }
        }
        return true;
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


    public static boolean hasCorrectFormat(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c) && c != ',') {
                return false;
            }
        }
        return true;
    }
}
