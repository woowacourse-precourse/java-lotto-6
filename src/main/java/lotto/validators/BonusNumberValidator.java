package lotto.validators;

import static lotto.constant.ErrorMessage.INPUT_BONUS_NUMBER_IN_WINNING_NUMBERS;
import static lotto.constant.ErrorMessage.INPUT_BONUS_NUMBER_OUT_OF_RANGE;
import static lotto.constant.LottoInfo.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoInfo.MIN_LOTTO_NUMBER;

import java.util.List;

public class BonusNumberValidator {
    public static void validBonusNumberInWinningNumbers(List<Integer> winningNumbers, Integer bonusNumber) {
        if (isBonusNumberInWinningNumbers(winningNumbers, bonusNumber)) {
            throw new IllegalArgumentException(INPUT_BONUS_NUMBER_IN_WINNING_NUMBERS);
        }
    }

    public static void validBonusNumberInRange(Integer bonusNumber) {
        if (!isBonusNumberInRange(bonusNumber)) {
            throw new IllegalArgumentException(INPUT_BONUS_NUMBER_OUT_OF_RANGE);
        }
    }

    private static boolean isBonusNumberInWinningNumbers(List<Integer> winningNumbers, Integer bonusNumber) {
        return winningNumbers.contains(bonusNumber);
    }

    private static boolean isBonusNumberInRange(Integer bonusNumber) {
        return bonusNumber >= MIN_LOTTO_NUMBER && bonusNumber <= MAX_LOTTO_NUMBER;
    }
}
