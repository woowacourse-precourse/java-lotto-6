package lotto.domain.winning.validator;

import java.util.List;
import lotto.constant.Constant;
import lotto.constant.errorMessage.exception.CustomIllegalArgumentException;
import lotto.constant.errorMessage.exception.CustomIllegalStateAmountException;
import lotto.constant.errorMessage.winning.WinningExceptionStatus;

public class WinningNumbersValidator {

    private static final WinningNumbersValidator WINNING_NUMBERS_VALIDATOR = new WinningNumbersValidator();

    private WinningNumbersValidator() {
    }

    public static void validateWinningNumbers(final List<Integer> numbers, final int bonusNumber) {
        WINNING_NUMBERS_VALIDATOR.validateBonusNumberIsDuplicated(numbers, bonusNumber);
        WINNING_NUMBERS_VALIDATOR.validateBonusNumberOutOfRange(bonusNumber);
    }

    private void validateBonusNumberOutOfRange(final int bonusNumber) {
        if (isOutOfRange(bonusNumber)) {
            throw new CustomIllegalStateAmountException(WinningExceptionStatus.BONUS_NUMBER_IS_OUT_OF_RANGE);
        }
    }

    private boolean isOutOfRange(final int bonusNumber) {
        return bonusNumber < Constant.ALLOWED_MINIMUM_LOTTO_NUMBER
                || Constant.ALLOWED_MAXIMUM_LOTTO_NUMBER < bonusNumber;
    }

    private void validateBonusNumberIsDuplicated(final List<Integer> numbers, final int bonusNumber) {
        if (isDuplicated(numbers, bonusNumber)) {
            throw new CustomIllegalArgumentException(WinningExceptionStatus.BONUS_NUMBER_IS_DUPLICATED);
        }
    }

    private boolean isDuplicated(final List<Integer> numbers, final int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
