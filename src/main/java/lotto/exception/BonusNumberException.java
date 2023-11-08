package lotto.exception;

import lotto.constant.ExceptionConstant;
import lotto.constant.LottoConstant;

import java.util.List;

public class BonusNumberException extends IllegalArgumentException {

    public BonusNumberException(String message) {
        super(message);
    }

    public static void ensureValidFormat(String inputBonusNumber) {
        if (!inputBonusNumber.matches(ExceptionConstant.BONUS_NUMBER_PATTERN)) {
            throw new BonusNumberException(ExceptionConstant.BONUS_NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    public static void ensureNotDuplicatedWithWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new BonusNumberException(ExceptionConstant.BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
    }

    public static void ensureWithinValidRange(int bonusNumber) {
        if (bonusNumber < LottoConstant.MIN_LOTTO_NUMBER || bonusNumber > LottoConstant.MAX_LOTTO_NUMBER) {
            throw new BonusNumberException(ExceptionConstant.BONUS_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }
}