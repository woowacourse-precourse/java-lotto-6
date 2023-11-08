package lotto.domain;

import lotto.exception.NumberOutOfRangeException;

public class BonusNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final Integer bonusNumber;

    public BonusNumber(Integer bonusNumber) {
        validateBonusRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Integer getBonusNumber() {
        return this.bonusNumber;
    }

    public boolean equals(Integer bonusNumber) {
        return this.bonusNumber.equals(bonusNumber);
    }

    private void validateBonusRange(Integer bonusNumber) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new NumberOutOfRangeException();
        }
    }
}
