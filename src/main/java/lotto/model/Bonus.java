package lotto.model;


import lotto.utils.Constants;
import lotto.utils.ExceptionMessage;

public record Bonus(int bonusNumber) {

    public Bonus {
        validate(bonusNumber);
    }

    private void validate(int bonusNumber) {
        validateBonusNumberRange(bonusNumber);
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < Constants.MIN_RANGE || bonusNumber > Constants.MAX_RANGE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_RANGE.getMessage());
        }
    }

}
