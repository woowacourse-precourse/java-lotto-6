package lotto.validator.domain;

import java.util.List;
import lotto.domain.lotto.LottoCondition;
import lotto.validator.domain.exception.DomainExceptionMessage;

public class LottoNumbersValidator {

    private LottoNumbersValidator() {
    }

    public static void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicates(numbers);
        validateRange(numbers);
    }

    private static void validateRange(final List<Integer> numbers) {
        if (isOutOfRange(numbers)) {
            throw DomainExceptionMessage.OUT_OF_RANGE_NUMBER.create();
        }
    }

    private static boolean isOutOfRange(final List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(LottoCondition::isNotInRange);
    }

    private static void validateLength(final List<Integer> numbers) {
        if (LottoCondition.isInvalidLength(numbers.size())) {
            throw DomainExceptionMessage.INVALID_LOTTO_LENGTH.create();
        }
    }

    private static void validateDuplicates(final List<Integer> numbers) {
        if (isDuplicate(numbers)) {
            throw DomainExceptionMessage.DUPLICATES_LOTTO_NUMBERS.create();
        }
    }

    private static boolean isDuplicate(final List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .toList()
                .size() != numbers.size();
    }
}
