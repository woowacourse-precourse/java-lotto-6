package lotto.util.validators;

import static lotto.util.Constants.ERROR;
import static lotto.util.Constants.MAX_NUMBER;
import static lotto.util.Constants.ZERO;
import static lotto.util.enums.ErrorMessage.NUMBER_CANNOT_PARSE;

import lotto.model.WinningNumbers;
import lotto.util.exception.input.BonusNumberNotUniqueException;
import lotto.util.exception.input.NumberGreaterException;
import lotto.util.exception.input.NumbersNegativeException;
import lotto.util.exception.input.NumbersNullException;

public class BonusNumberValidator {
    public static void validateBonusNumber(String bonusNumbers, WinningNumbers winningNumbers) {
        validateNotNullAndNotEmpty(bonusNumbers);
        validParseNumber(bonusNumbers);
        validateBonusNumberContains(bonusNumbers, winningNumbers);
        validateNonPositiveBonusNumber(bonusNumbers);
        validateMaxNumber(bonusNumbers);
    }

    private static void validateMaxNumber(String bonusNumbers) {
        if (Integer.parseInt(bonusNumbers) > MAX_NUMBER) {
            throw new NumberGreaterException();
        }
    }

    private static void validateNotNullAndNotEmpty(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new NumbersNullException();
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

    private static void validParseNumber(String numbers) {
        try {
            Integer.parseInt(numbers);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERROR + NUMBER_CANNOT_PARSE.getMessage());
        }
    }
}
