package lotto.domain;

import lotto.exception.ErrorStatus;
import lotto.exception.LottoArgumentException;

public class BonusBall {

    private final int bonusNumber;

    public BonusBall(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(int bonusNumber) {
        validateRange(bonusNumber);
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < Lotto.MIN_NUMBER || bonusNumber > Lotto.MAX_NUMBER) {
            throw new LottoArgumentException(ErrorStatus.BONUS_NUMBER_RANGE_ERROR);
        }
    }
}
