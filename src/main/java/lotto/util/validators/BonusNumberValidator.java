package lotto.util.validators;

import static lotto.util.Constants.ZERO;

import lotto.model.WinningNumbers;
import lotto.util.exception.input.BonusNumberNotUniqueException;
import lotto.util.exception.input.NumberGreaterException;
import lotto.util.exception.input.NumbersEmptyException;
import lotto.util.exception.input.NumbersNegativeException;
import lotto.util.exception.input.NumbersNullException;

public class BonusNumberValidator {
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
            throw new NumbersNullException();
        }

        if (numbers.isEmpty()) {
            throw new NumbersEmptyException();
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
            throw new NumbersNegativeException();
        }
    }
}
