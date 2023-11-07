package lotto.model;

import lotto.exceptionMessages.ExceptionMessages;

public class BonusNumber {
    private final int bonusNumber;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;

    public BonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        if (isInvalidRange(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessages.EXCEPTION_NUMBER_RANGE.getMessage());
        }
    }

    private boolean isInvalidRange(int bonusNumber) {
        return bonusNumber < MIN_RANGE || bonusNumber > MAX_RANGE;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
