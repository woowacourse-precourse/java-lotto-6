package lotto.domain;


import lotto.exception.bonusnumber.BonusNumberRangeException;
import lotto.exception.bonusnumber.SameBonusNumberException;

import static lotto.utils.LottoConstants.LOTTO_MAXIMUM_VALUE;
import static lotto.utils.LottoConstants.LOTTO_MINIMUM_VALUE;

public class BonusNumber {

    private final int bonusNumber;

    private BonusNumber(Lotto answerLotto, int bonusNumber) {
        validateBonusNumber(answerLotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber of(Lotto answerLotto, int bonusNumber) {
        return new BonusNumber(answerLotto, bonusNumber);
    }

    private void validateBonusNumber(Lotto answerLotto, int bonusNumber) {
        validateBonusNumberSize(bonusNumber);
        validateDuplicateBonusNumber(answerLotto, bonusNumber);
    }

    private void validateDuplicateBonusNumber(Lotto answerLotto, int bonusNumber) {
        if (answerLotto.containsBonusNumber(bonusNumber)) {
            throw new SameBonusNumberException();
        }
    }

    private void validateBonusNumberSize(int bonusNumber) {
        if (bonusNumber < LOTTO_MINIMUM_VALUE.getConstants() || bonusNumber > LOTTO_MAXIMUM_VALUE.getConstants()) {
            throw new BonusNumberRangeException();
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
