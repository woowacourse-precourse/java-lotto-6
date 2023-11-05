package lotto.domain.lottery;

import lotto.domain.checker.NumberChecker;
import lotto.domain.parser.Parser;
import lotto.exception.LottoException;

import static lotto.exception.ErrorMessage.BONUS_NUMBER_DUPLICATED;

public final class Prize extends NumberChecker {
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

    private void validateDuplicatedBonusNumber(final int number) {
        if (prizeNumbers.isAlreadyContainBonusNumber(number)) {
            throw LottoException.from(BONUS_NUMBER_DUPLICATED);
        }
    }

    public Lotto getPrizeNumbers() {
        return prizeNumbers;
    }
}
