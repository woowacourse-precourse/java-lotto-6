package lotto.domain;


import lotto.exception.bonusnumber.BonusNumberRangeException;
import lotto.exception.bonusnumber.SameBonusNumberException;

public class BonusNumber {

    private static final int LOTTO_MINIMUM_VALUE = 1;
    private static final int LOTTO_MAXIMUM_VALUE = 45;
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
        if (bonusNumber < LOTTO_MINIMUM_VALUE || bonusNumber > LOTTO_MAXIMUM_VALUE) {
            throw new BonusNumberRangeException();
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
