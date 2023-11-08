package lotto.validator;

import lotto.constant.ErrorConstants;
import lotto.constant.LottoConstants;
import lotto.util.Utils;

import java.util.List;

public class BonusLottoValidator {
    public static boolean isInvalid(String bonusLotto) {
        try {
            Utils.convertStringToInt(bonusLotto);
        } catch (NumberFormatException e) {
            System.out.println(ErrorConstants.ERROR + ErrorConstants.INVALID_BONUS_LOTTO);
            return true;
        }
        return false;
    }

    public static boolean isInvalidNumber(String bonusLottoString) {
        int bonusLotto = Utils.convertStringToInt(bonusLottoString);

        if (bonusLotto > LottoConstants.MAX_LOTTO_NUMBER || bonusLotto < LottoConstants.MIN_LOTTO_NUMBER) {
            System.out.println(ErrorConstants.ERROR + ErrorConstants.BONUS_LOTTO_OUT_OF_RANGE);
            return true;
        }
        return false;
    }

    public static boolean isDuplicated(String bonusLottoString, List<Integer> winningLotto) {
        int bonusLotto = Utils.convertStringToInt(bonusLottoString);

        if (winningLotto.contains(bonusLotto)) {
            System.out.println(ErrorConstants.ERROR + ErrorConstants.DUPLICATE_BONUS_LOTTO);
            return true;
        }
        return false;
    }
}
