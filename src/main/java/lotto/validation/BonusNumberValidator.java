package lotto.validation;

import static lotto.constants.Constants.LOTTO_NUMBER_RANGE_END;
import static lotto.constants.Constants.LOTTO_NUMBER_RANGE_START;

import lotto.domain.Lotto;
import lotto.exception.NumberDuplicateException;
import lotto.exception.NumberRangeException;

public class BonusNumberValidator extends Validator {

    public static void validateBonusReadLine(String readline) {
        checkBlank(readline);
        checkDigit(readline);
    }

    public static void validateBonusNumber(int bonus, Lotto winningLottos) {
        validateBonusDuplicateLotto(bonus, winningLottos);
        validateBonusRange(bonus);
    }

    private static void validateBonusDuplicateLotto(int bonus, Lotto winningLottos) {
        if (winningLottos.isContainNumber(bonus)) {
            throw NumberDuplicateException.numberDuplicateException;
        }
    }

    private static void validateBonusRange(int bonus) {
        if ((bonus < LOTTO_NUMBER_RANGE_START) || (bonus > LOTTO_NUMBER_RANGE_END)) {
            throw NumberRangeException.numberRangeException;
        }
    }

}
