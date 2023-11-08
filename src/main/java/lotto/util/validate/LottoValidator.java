package lotto.util.validate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.Constant;
import lotto.util.ErrorMessage;

public class LottoValidator {
    public static void validateLotto(List<Integer> numbers) {
        checkDuplicate(numbers);
        checkValidRangeNumber(numbers);
    }

    private static void checkDuplicate(List<Integer> numbers) {
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR.getMessage());
        }
    }

    private static void checkValidRangeNumber(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(number -> number < Constant.LOTTO_NUMBER_MIN || number > Constant.LOTTO_NUMBER_MAX)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
        }
    }

    private static boolean hasDuplicate(List<Integer> numbers) {
        Set<Integer> checkNumbers = new HashSet<>(numbers);
        return checkNumbers.size() != numbers.size();
    }
}
