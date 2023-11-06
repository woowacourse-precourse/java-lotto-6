package lotto.validation;

import lotto.domain.WinningNumber;
import lotto.enums.ErrorMessage;
import lotto.enums.LottoValue;

public class BonusNumberValidator {

    private BonusNumberValidator() {
    }

    public static void validateRange(int number) {
        int minNumberRange = LottoValue.MIN_LOTTO_NUMBER_RANGE.getValue();
        int maxNumberRange = LottoValue.MAX_LOTTO_NUMBER_RANGE.getValue();
        if (number < minNumberRange || number > maxNumberRange) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE.getMessage());
        }
    }

    public static void validateNotContainedInWinningNumber(int number, WinningNumber winningNumber) {
        if (winningNumber.isContains(number)) {
            throw new IllegalArgumentException(ErrorMessage.EXIST_IN_WINNING_NUMBER.getMessage());
        }
    }
}
