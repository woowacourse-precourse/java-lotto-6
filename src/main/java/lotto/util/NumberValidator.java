package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.ErrorMessage;

public class NumberValidator {
    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 45;
    static Set<Integer> set;
    public static void validateNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            isValidNumber(number);
        }
    }

    private static void isValidNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE.toString());
        }
    }

    public static void validateDuplicates(List<Integer> numbers) {
        set = new HashSet<>();
        for (int number : numbers) {
            checkDuplicates(number);
        }
    }

    private static void checkDuplicates(int number) {
        if (!set.add(number)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DUPLICATE.toString());
        }
    }
}
