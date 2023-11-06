package lotto.validate;

import static lotto.constants.LottoConstants.LOTTO_END;
import static lotto.constants.LottoConstants.LOTTO_START;

import lotto.exception.ExceptionManager;
import lotto.model.Lotto;

public class WinningLottoWithBonusValidate {

    public static void valid(Lotto lotto, int number) {
        checkBonusNumRange(number);
        checkDuplicate(lotto, number);
    }

    private static void checkBonusNumRange(int number) {
        if (number < LOTTO_START || number > LOTTO_END) {
            throw ExceptionManager.BEGIN_ERROR.createIllegalArgumentException(
                    "로또의 숫자는 " + LOTTO_START + "~" + LOTTO_END + "까지 가능합니다.");
        }
    }

    private static void checkDuplicate(Lotto lotto, int number) {
        if (lotto.getNumbers().contains(number)) {
            throw ExceptionManager.BEGIN_ERROR.createIllegalArgumentException(
                    "로또의 숫자는 중복될 수 없습니다.");
        }
    }
}
