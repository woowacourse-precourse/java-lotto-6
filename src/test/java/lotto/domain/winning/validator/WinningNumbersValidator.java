package lotto.domain.winning.validator;

import java.util.List;
import lotto.constant.errorMessage.input.IllegalArgumentAmountException;
import lotto.constant.errorMessage.winning.WinningExceptionStatus;

public class WinningNumbersValidator {

    private static final WinningNumbersValidator WINNING_NUMBERS_VALIDATOR = new WinningNumbersValidator();

    private WinningNumbersValidator() {
    }

    public static void validateWinningNumbers(final List<Integer> numbers, final int bonusNumber) {
        WINNING_NUMBERS_VALIDATOR.validateBonusNumberIsDuplicated(numbers, bonusNumber);
    }

    private void validateBonusNumberIsDuplicated(final List<Integer> numbers, final int bonusNumber) {
        if (isDuplicated(numbers, bonusNumber)) {
            throw new IllegalArgumentAmountException(WinningExceptionStatus.BONUS_NUMBER_IS_DUPLICATED);
        }
    }

    private boolean isDuplicated(final List<Integer> numbers, final int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
