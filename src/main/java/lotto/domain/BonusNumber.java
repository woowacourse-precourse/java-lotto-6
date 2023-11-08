package lotto.domain;

import lotto.config.Constant;

public class BonusNumber {

    private int bonusNumber;

    public BonusNumber(int bonusNumber) {
        if (bonusNumber < Constant.MIN_LOTTO_NUMBER || bonusNumber > Constant.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(Constant.NUMBER_RANGE_EXCEPTION);
        }
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
