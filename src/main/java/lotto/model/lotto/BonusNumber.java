package lotto.model.lotto;

import static lotto.exception.ExceptionMessage.BONUS_NUMBER_DUPLICATION;
import static lotto.exception.ExceptionMessage.LOTTO_NUMBER_OUT_OF_RANGE;
import static lotto.utils.constant.LottoConstant.LOTTO_NUMBER_MAX;
import static lotto.utils.constant.LottoConstant.LOTTO_NUMBER_MIN;

public class BonusNumber {
    private final int bonusNumber;

    private BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber of(int bonusNumber) {
        validateBonusNumberInRange(bonusNumber);
        return new BonusNumber(bonusNumber);
    }

    public void validateBonusNumberDuplicated(Lotto lotto) {
        if (lotto.isNumberExist(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATION.getMessage());
        }
    }

    private static void validateBonusNumberInRange(int bonusNumber) {
        if (bonusNumber < LOTTO_NUMBER_MIN.getValue() || bonusNumber > LOTTO_NUMBER_MAX.getValue()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }
}
