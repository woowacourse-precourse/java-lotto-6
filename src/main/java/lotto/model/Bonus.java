package lotto.model;

import lotto.constant.ErrorMessage;
import lotto.constant.Rule;

public class Bonus {

    private final Integer bonusNumber;

    public Bonus(Integer bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(Integer bonusNumber) {
        validateRange(bonusNumber);
    }

    private void validateRange(Integer bonusNumber) {
        if (bonusNumber < Rule.MIN_NUMBER || bonusNumber > Rule.MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_RANGE.getMessage());
        }
    }

    public Boolean hasBonusNumber(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
