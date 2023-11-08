package lotto.domain;

import lotto.config.Constant;

public class BonusNumber {

    private int bonusNumber;

    public BonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(Constant.NUMBER_RANGE_EXCEPTION);
        }
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
