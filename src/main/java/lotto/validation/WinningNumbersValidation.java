package lotto.validation;

import static lotto.constant.ErrorMessage.NUMBER_IN_RANGE_EXCEPTION;
import static lotto.constant.LottoConstant.LAST_LOTTO_NUMBER;
import static lotto.constant.LottoConstant.START_LOTTO_NUMBER;

public class WinningNumbersValidation {
    public static void validateNumberInRange(int winningNumber) {
        if (!isNumberInRange(winningNumber)) {
            throw new IllegalArgumentException(NUMBER_IN_RANGE_EXCEPTION.getMessage());
        }
    }

    private static boolean isNumberInRange(int winningNumber) {
        return START_LOTTO_NUMBER <= winningNumber && winningNumber <= LAST_LOTTO_NUMBER;
    }
}
