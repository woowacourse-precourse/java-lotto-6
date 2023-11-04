package lotto.domain;

import lotto.exception.ExceptionMessage;

public class Bonus {
    private final int bonusNumber;

    private Bonus(int bonusNumber) {
        validateRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static Bonus from(int inputToNumber) {
        return new Bonus(inputToNumber);
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber > 45 || bonusNumber < 1) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE_NUMBER.getErrorDescription());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
