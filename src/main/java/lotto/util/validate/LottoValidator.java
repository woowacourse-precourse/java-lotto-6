package lotto.util.validate;

import static lotto.util.Constant.*;
import static lotto.util.ErrorMessage.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {
    public static void validate(List<Integer> numbers) {
        checkDuplicate(numbers);
        checkValidRangeNumber(numbers);
    }

    private static void checkDuplicate(List<Integer> numbers) {
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_ERROR.getMessage());
        }
    }

    private static void checkValidRangeNumber(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(number -> number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX)) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
        }
    }

    private static boolean hasDuplicate(List<Integer> numbers) {
        Set<Integer> checkNumbers = new HashSet<>(numbers);
        return checkNumbers.size() != numbers.size();
    }
}
