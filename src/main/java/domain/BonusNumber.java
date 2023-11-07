package domain;

import constant.ConstantNumber;
import constant.ExceptionMessage;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(Lotto lotto, int bonusNumber) {
        validate(lotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto lotto, int bonusNumber) {
        validateRange(bonusNumber);
        validateDuplicateNumber(lotto, bonusNumber);
    }

    private static void validateRange(int bonusNumber) {
        if (bonusNumber > ConstantNumber.MAXIMUM_WINNING_NUMBER.get() ||
                bonusNumber < ConstantNumber.MINIMUM_WINNING_NUMBER.get()) {
            throw new IllegalArgumentException(ExceptionMessage.WINNING_NUMBER_OUT_OF_RANGE.get());
        }
    }

    private void validateDuplicateNumber(Lotto lotto, int bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.BONUS_NUMBER_EQUALS_WINNING_NUMBERS.get());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
