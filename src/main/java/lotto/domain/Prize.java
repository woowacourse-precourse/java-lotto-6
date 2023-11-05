package lotto.domain;

import lotto.domain.parser.Parser;
import lotto.exception.LottoException;

import static lotto.domain.constants.LottoConstraint.NUMBER_LOWER_BOUND;
import static lotto.domain.constants.LottoConstraint.NUMBER_UPPER_BOUND;
import static lotto.exception.ErrorMessage.BONUS_NUMBER_DUPLICATED;
import static lotto.exception.ErrorMessage.NUMBER_OUT_OF_RANGE;

public class Prize {
    private final Lotto prizeNumbers;
    private final int bonusNumber;

    private Prize(
            final Lotto prizeNumbers,
            final String bonusNumberInput
    ) {
        this.prizeNumbers = prizeNumbers;

        int parsedBonusNumber = Parser.parseStringToInt(bonusNumberInput);
        validateNumberRange(parsedBonusNumber);
        validateDuplicatedBonusNumber(parsedBonusNumber);

        this.bonusNumber = parsedBonusNumber;
    }

    public static Prize of(
            final Lotto prizeNumbers,
            final String bonusNumberInput
    ) {
        return new Prize(prizeNumbers, bonusNumberInput);
    }

    public void validateNumberRange(final int number) {
        if (isOutOfRange(number)) {
            throw LottoException.from(NUMBER_OUT_OF_RANGE);
        }
    }

    public void validateDuplicatedBonusNumber(final int number) {
        if (prizeNumbers.isAlreadyContainBonusNumber(number)) {
            throw LottoException.from(BONUS_NUMBER_DUPLICATED);
        }
    }

    private static boolean isOutOfRange(int number) {
        return isBiggerThanUpperBound(number) || isSmallerThanLowerBound(number);
    }

    private static boolean isSmallerThanLowerBound(int number) {
        return number > NUMBER_UPPER_BOUND.getValue();
    }

    private static boolean isBiggerThanUpperBound(int number) {
        return number < NUMBER_LOWER_BOUND.getValue();
    }
}
