package lotto.validators;

import static lotto.constant.ErrorMessage.INPUT_WINNING_NUMBER_COUNT_IS_INCORRECT;
import static lotto.constant.LottoInfo.LOTTO_NUMBER_COUNT;

public class WinningNumberValidator {
    public static void validWinningNumberCount(String[] winningNumbers) {
        if (!isCorrectWinningNumberCount(winningNumbers)) {
            throw new IllegalArgumentException(INPUT_WINNING_NUMBER_COUNT_IS_INCORRECT);
        }
    }
    
    private static boolean isCorrectWinningNumberCount(String[] winningNumbers) {
        return winningNumbers.length == LOTTO_NUMBER_COUNT;
    }
}
