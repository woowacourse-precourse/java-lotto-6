package lotto.validator;

import java.util.List;
import lotto.domain.enums.LottoConstraint;
import lotto.domain.enums.Message;

public class LottoNumberValidator extends Validator {
    public static void validate(final List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicates(numbers);
        validateRange(numbers);
    }

    private static void validateRange(final List<Integer> numbers) {
        if (isOutOfRange(numbers)) {
            throw Message.ERROR_INVALID_RANGE_MESSAGE.createException();
        }
    }

    private static boolean isOutOfRange(final List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number-> number < LottoConstraint.START_RANGE_NUMBER.getValue() || number > LottoConstraint.END_RANGE_NUMBER.getValue());
    }

    private static void validateLength(final List<Integer> numbers) {
        if (numbers.size() != LottoConstraint.VALID_LOTTO_SIZE.getValue()) {
            throw Message.ERROR_MISSING_SIX_NUMBERS_MESSAGE.createException();
        }
    }

    private static void validateDuplicates(final List<Integer> numbers) {
        if (isDuplicate(numbers)) {
            throw Message.ERROR_DUPLICATE_NUMBER_MESSAGE.createException();
        }
    }

    private static boolean isDuplicate(final List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .toList()
                .size() != numbers.size();
    }
}