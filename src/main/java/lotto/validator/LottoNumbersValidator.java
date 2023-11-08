package lotto.validator;

import java.util.List;
import lotto.domain.constants.LottoConstraint;
import lotto.domain.message.ErrorMessage;

public class LottoNumbersValidator {
    public static List<Integer> validate(final List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicates(numbers);
        validateRange(numbers);
        return numbers;
    }

    private static void validateRange(final List<Integer> numbers) {
        if (isOutOfRange(numbers)) {
            throw ErrorMessage.OUT_OF_RANGE.createException();
        }
    }

    private static boolean isOutOfRange(final List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number-> number < LottoConstraint.MIN_NUMBER.getValue() || number > LottoConstraint.MAX_NUMBER.getValue());
    }

    private static void validateLength(final List<Integer> numbers) {
        if (numbers.size() != LottoConstraint.LOTTO_SIZE.getValue()) {
            throw ErrorMessage.INVALID_LOTTO_LENGTH.createException();
        }
    }

    private static void validateDuplicates(final List<Integer> numbers) {
        if (isDuplicate(numbers)) {
            throw ErrorMessage.DUPLICATES_LOTTO_NUMBERS.createException();
        }
    }

    private static boolean isDuplicate(final List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .toList()
                .size() != numbers.size();
    }
}
