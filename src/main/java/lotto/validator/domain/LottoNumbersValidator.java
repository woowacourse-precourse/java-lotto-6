package lotto.validator.domain;

import java.util.List;
import lotto.domain.lotto.LottoCondition;
import lotto.validator.domain.exception.DomainExceptionMessage;
import lotto.validator.domain.exception.DomainIllegalArgumentException;

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
            throw new DomainIllegalArgumentException(DomainExceptionMessage.OUT_OF_RANGE_NUMBER);
        }
    }

    private static boolean isOutOfRange(final List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(LottoCondition::isNotInRange);
    }

    private static void validateLength(final List<Integer> numbers) {
        if (LottoCondition.isInvalidLength(numbers.size())) {
            throw new DomainIllegalArgumentException(DomainExceptionMessage.INVALID_LOTTO_LENGTH);
        }
    }

    private static void validateDuplicates(final List<Integer> numbers) {
        if (isDuplicate(numbers)) {
            throw new DomainIllegalArgumentException(DomainExceptionMessage.DUPLICATES_LOTTO_NUMBERS);
        }
    }

    private static boolean isDuplicate(final List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .toList()
                .size() != numbers.size();
    }
}
