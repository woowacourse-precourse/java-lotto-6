package lotto.domain.lottery;

import lotto.exception.LottoException;

import java.util.List;
import java.util.Objects;

import static lotto.domain.lottery.constants.LottoConstraint.NUMBER_LOWER_BOUND;
import static lotto.domain.lottery.constants.LottoConstraint.NUMBER_UPPER_BOUND;
import static lotto.exception.ErrorMessage.NUMBER_DUPLICATED;
import static lotto.exception.ErrorMessage.NUMBER_OUT_OF_RANGE;

public abstract class NumberChecker {

    // Exception Handling Method
    protected void validateNumbersRange(final List<Integer> numbers) {
        if (areOutOfRange(numbers)) {
            throw LottoException.from(NUMBER_OUT_OF_RANGE);
        }
    }

    protected void validateNumberRange(final Integer number) {
        if (isOutOfRange(number)) {
            throw LottoException.from(NUMBER_OUT_OF_RANGE);
        }
    }

    protected void validateDuplicatedList(final List<Integer> numbers) {
        if (isDuplicated(numbers)) {
            throw LottoException.from(NUMBER_DUPLICATED);
        }
    }

    // Validation Method
    private boolean areOutOfRange(final List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(NumberChecker::isOutOfRange);
    }

    protected static boolean isOutOfRange(final Integer number) {
        return isSmallerThanLowerBound(number) || isBiggerThanUpperBound(number);
    }

    private static boolean isSmallerThanLowerBound(final Integer number) {
        return number > NUMBER_UPPER_BOUND.getValue();
    }

    private static boolean isBiggerThanUpperBound(final Integer number) {
        return number < NUMBER_LOWER_BOUND.getValue();
    }

    private boolean isDuplicated(final List<Integer> numbers) {
        final int uniqueNumberCount = (int) numbers.stream().distinct().count();

        return !Objects.equals(numbers.size(), uniqueNumberCount);
    }
}
