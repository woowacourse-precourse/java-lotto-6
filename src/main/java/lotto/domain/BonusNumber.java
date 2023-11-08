package lotto.domain;

import static lotto.domain.Lotto.MAX_NUMBER;
import static lotto.domain.Lotto.MIN_NUMBER;
import static lotto.error.ErrorMessage.BONUS_NUMBER_OUT_OF_RANGE;
import static lotto.error.ErrorMessage.DUPLICATE_BONUS_NUMBER;
import static lotto.error.ErrorMessage.INVALID_BONUS_NUMBER_FORMAT;

public class BonusNumber {
    private final Integer bonusNumber;

    private BonusNumber(Integer bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber from(String input, WinningNumbers winningNumbers) {
        return new BonusNumber(validateBonusNumber(winningNumbers, input));
    }

    private static Integer validateBonusNumber(WinningNumbers winningNumbers, String input) {
        Integer bonusNumber = validateFormatAndConvert(input, INVALID_BONUS_NUMBER_FORMAT);
        validateRange(bonusNumber, BONUS_NUMBER_OUT_OF_RANGE);
        validateDuplicate(winningNumbers, bonusNumber, DUPLICATE_BONUS_NUMBER);
        return bonusNumber;
    }

    private static Integer validateFormatAndConvert(String input, String error) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(error);
        }
    }

    private static void validateRange(Integer number, String error) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(error);
        }
    }

    private static void validateDuplicate(WinningNumbers winningNumbers, Integer number, String error) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(error);
        }
    }

    public boolean equals(Integer number) {
        return bonusNumber.equals(number);
    }
}
