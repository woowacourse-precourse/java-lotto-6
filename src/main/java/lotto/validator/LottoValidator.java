package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constant.NumberConstants.*;
import static lotto.constant.MessageConstants.*;

public class LottoValidator {
    public static void validate_all(List<Integer> numbers) {
        validateSize(numbers);
        validateOverlap(numbers);
        validateRange(numbers);
    }

    public static void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        validateBonusRange(bonusNumber);
        validateBonusOverlap(numbers, bonusNumber);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(NUMBER_SIZE_ERROR_MESSAGE);
        }
    }

    private static void validateOverlap(List<Integer> numbers) {
        Set<Integer> checkOverlap = new HashSet<>(numbers);
        if (checkOverlap.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(NUMBER_OVERLAP_ERROR_MESSAGE);
        }
    }


    private static void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
                throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
            }
        }
    }

    private static void validateBonusRange(int bonusNumber) {
        if (bonusNumber < LOTTO_NUMBER_MIN || bonusNumber > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    private static void validateBonusOverlap(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(NUMBER_OVERLAP_ERROR_MESSAGE);
        }
    }
}
