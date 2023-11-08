package lotto.util.validate;

import static lotto.util.ErrorMessage.*;

import lotto.model.BonusNumber;
import lotto.model.Lotto;

public class WinningLottoValidator {

    public static void validate(Lotto lotto, BonusNumber bonusNumber) {
        checkBonusNumberDuplicate(lotto, bonusNumber);
    }

    private static void checkBonusNumberDuplicate(Lotto lotto, BonusNumber bonusNumber) {
        if (isContain(lotto, bonusNumber)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_ERROR.getMessage());
        }
    }

    private static boolean isContain(Lotto lotto, BonusNumber bonusNumber) {
        return lotto.getNumbers()
                .contains(bonusNumber.getBonusNumber());
    }
}
