package lotto.validator;

import lotto.exception.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constants.LottoConstants.*;

public class LottoValidator {
    public static void validateRange(int number) {
        if (number < MINIMUM_RANGE || number > MAXIMUM_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_INVALID_RANGE.getMessage());
        }
    }

    public static int validateNumeric(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_NOT_NUMERIC.getMessage());
        }
    }

    public static void validateNumbersInRange(List<Integer> numbers) {
        numbers.forEach(LottoValidator::validateRange);
    }

    public static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_DUPLICATED.getMessage());
        }
    }
}
