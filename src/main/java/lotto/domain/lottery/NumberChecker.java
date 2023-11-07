package lotto.domain.lottery;

import java.util.List;

import static lotto.domain.lottery.constants.LottoConstraint.NUMBER_LOWER_BOUND;
import static lotto.domain.lottery.constants.LottoConstraint.NUMBER_UPPER_BOUND;

public abstract class NumberChecker {
    // Validation Method
    protected boolean areOutOfRange(final List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(this::isOutOfRange);
    }

    protected boolean isOutOfRange(final Integer number) {
        return isSmallerThanLowerBound(number) || isBiggerThanUpperBound(number);
    }

    private boolean isSmallerThanLowerBound(final Integer number) {
        return number > NUMBER_UPPER_BOUND.getValue();
    }

    private boolean isBiggerThanUpperBound(final Integer number) {
        return number < NUMBER_LOWER_BOUND.getValue();
    }
}
