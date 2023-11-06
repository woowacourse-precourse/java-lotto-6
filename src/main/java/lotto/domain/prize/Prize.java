package lotto.domain.prize;

import lotto.domain.lottery.Lotto;
import lotto.domain.lottery.NumberChecker;
import lotto.domain.lottery.Parser;
import lotto.exception.LottoException;

import static lotto.exception.ErrorMessage.BONUS_NUMBER_DUPLICATED;

public final class Prize extends NumberChecker {
    private final Lotto prizeNumbers;
    private final int bonusNumber;

    // Constructor
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

    // Static Factory Method
    public static Prize of(
            final Lotto prizeNumbers,
            final String bonusNumberInput
    ) {
        return new Prize(prizeNumbers, bonusNumberInput);
    }

    // Utility Method
    public boolean isPrizeNumber(final int comparableNumber) {
        return prizeNumbers.hasNumber(comparableNumber);
    }

    public boolean isBonusNumber(final int comparableNumber) {
        return bonusNumber == comparableNumber;
    }

    // Exception Handling Method
    private void validateDuplicatedBonusNumber(final int number) {
        if (prizeNumbers.isAlreadyContainBonusNumber(number)) {
            throw LottoException.from(BONUS_NUMBER_DUPLICATED);
        }
    }

    // Getter
    public Lotto getPrizeNumbers() {
        return prizeNumbers;
    }
}
