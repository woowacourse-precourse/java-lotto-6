package lotto.validation;

import static lotto.messages.ErrorMessages.DUPLICATE_NAME_MESSAGE;
import static lotto.messages.ErrorMessages.INVALID_LOTTO_NUMBER_COUNT_MESSAGE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.ExceptionUtil;

public class IntegerListValidator {

    public static void validateDuplicated(List<Integer> numbers) {
        Set<Integer> deduplicatedNumbers = new HashSet<>(numbers);

        if (numbers.size() != deduplicatedNumbers.size()) {
            ExceptionUtil.throwInvalidValueException(DUPLICATE_NAME_MESSAGE.getMessage());
        }
    }

    public static void validateSize(List<Integer> numbers, int size) {
        if (numbers.size() != size) {
            ExceptionUtil.throwInvalidValueException(INVALID_LOTTO_NUMBER_COUNT_MESSAGE.getMessage());
        }
    }

    public static void validateEachIntegerInRange(List<Integer> numbers, int min, int max) {
        numbers.stream()
                .forEach(number -> IntegerValidator.validateInRange(number, min, max));
    }
}
