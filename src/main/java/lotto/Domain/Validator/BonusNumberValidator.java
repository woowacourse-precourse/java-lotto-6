package lotto.Domain.Validator;

import static lotto.Util.Constants.MAX_LOTTO_NUM;
import static lotto.Util.Constants.MIN_LOTTO_NUM;

import lotto.Util.ExceptionMessageFormatter;
import lotto.Util.LottoGameException;

public class BonusNumberValidator {

    public static void doValidate(int bonusNum) {
        if (!isInBoundary(bonusNum)) {
            throw new IllegalArgumentException(
                    ExceptionMessageFormatter.makeMessage(LottoGameException.WRONG_BOUNDARY_BONUS_NUMBER.getMessage()));
        }
    }

    private static boolean isInBoundary(int num) {
        return num >= MIN_LOTTO_NUM && num <= MAX_LOTTO_NUM;
    }
}
