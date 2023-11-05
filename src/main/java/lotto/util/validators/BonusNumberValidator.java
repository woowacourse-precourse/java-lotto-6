package lotto.util.validators;

import lotto.model.WinningNumbers;
import lotto.util.exception.input.BonusNumberNotUniqueException;
import lotto.util.exception.input.NumberGreaterException;
import lotto.util.exception.input.NumbersCannotEmpty;
import lotto.util.exception.input.NumbersCannotNegative;
import lotto.util.exception.input.NumbersCannotNull;

public class BonusNumberValidator {
    private static final int ZERO = 0;

    public static void validateBonusNumber(String bonusNumbers, WinningNumbers winningNumbers) {
        validateNotNullAndNotEmpty(bonusNumbers);
        validateBonusNumberContains(bonusNumbers, winningNumbers);
        validateNonPositiveBonusNumber(bonusNumbers);
        validateMaxNumber(bonusNumbers);
    }

    private static void validateMaxNumber(String bonusNumbers) {
        if (Integer.parseInt(bonusNumbers) > 45) {
            throw new NumberGreaterException();
        }
    }

    private static void validateNotNullAndNotEmpty(String numbers) {
        if (numbers == null) {
            throw new NumbersCannotNull();
        }

        if (numbers.isEmpty()) {
            throw new NumbersCannotEmpty();
        }
    }

    private static void validateBonusNumberContains(String bonusNumbers,
                                                    WinningNumbers winningNumbers) {
        if (winningNumbers.contains(Integer.valueOf(bonusNumbers))) {
            throw new BonusNumberNotUniqueException();
        }
    }

    private static void validateNonPositiveBonusNumber(String numbers) {
        if (Integer.parseInt(numbers) <= ZERO) {
            throw new NumbersCannotNegative();
        }
    }
}
