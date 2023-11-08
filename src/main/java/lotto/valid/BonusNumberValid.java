package lotto.valid;

import static lotto.consts.ErrorMsgConst.ERROR_BONUS_DUPLICATE_WINNUMBER;
import static lotto.consts.ErrorMsgConst.ERROR_BONUS_VALUE_RANGE;
import static lotto.consts.LottoConst.LOTTO_MAX_NUMBER;
import static lotto.consts.LottoConst.LOTTO_MIN_NUMBER;
import static lotto.valid.CommonValid.validNotBlank;
import static lotto.valid.CommonValid.validOnlyNumber;

import java.util.List;
import lotto.domain.WinNumber;

public class BonusNumberValid {

    public static int validBonusNumber(WinNumber winNumber, String input) {
        validNotBlank(input);
        int bonusNumber = validOnlyNumber(input);
        validNumValue(bonusNumber);
        validNotDuplicateWinNumber(winNumber, bonusNumber);
        return bonusNumber;
    }

    private static void validNumValue(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(ERROR_BONUS_VALUE_RANGE);
        }
    }

    private static void validNotDuplicateWinNumber(WinNumber winNumber, int bonusNumber) {
        List<Integer> lottoNums = winNumber.getLottoNums();
        if (lottoNums.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_BONUS_DUPLICATE_WINNUMBER);
        }
    }
}
