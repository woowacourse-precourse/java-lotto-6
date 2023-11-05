package lotto.domain;

import lotto.domain.parser.Parser;
import lotto.exception.LottoException;

import java.util.List;

import static lotto.domain.constants.LottoConstraint.NUMBER_LOWER_BOUND;
import static lotto.domain.constants.LottoConstraint.NUMBER_UPPER_BOUND;
import static lotto.exception.ErrorMessage.NUMBER_OUT_OF_RANGE;

public class Prize {
    private final Lotto prizeNumbers;
    private final int bonusNumber;

    private Prize(
            final Lotto prizeNumbers,
            final String bonusNumberInput
    ) {
        this.prizeNumbers = prizeNumbers;


        this.bonusNumber = Parser.parseStringToInt(bonusNumberInput);
    }

    public static Prize of(
            final Lotto prizeNumbers,
            final String bonusNumberInput
    ) {
        return new Prize(prizeNumbers, bonusNumberInput);
    }

    public void validateNumberRange(final List<Integer> numbers) {
        if (isInvalidRange(numbers)) {
            throw LottoException.from(NUMBER_OUT_OF_RANGE);
        }
    }

    public static boolean isInvalidRange(List<Integer> numbers) {
        return numbers.stream().anyMatch(Prize::isOutOfRange);
    }

    private static boolean isOutOfRange(Integer number) {
        return isBiggerThanUpperBound(number) || isSmallerThanLowerBound(number);
    }

    private static boolean isSmallerThanLowerBound(Integer number) {
        return number > NUMBER_UPPER_BOUND.getValue();
    }

    private static boolean isBiggerThanUpperBound(Integer number) {
        return number < NUMBER_LOWER_BOUND.getValue();
    }

}
