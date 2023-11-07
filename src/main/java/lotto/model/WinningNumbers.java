package lotto.model;

import static lotto.util.message.ErrorMessages.BONUS_NUMBER_DUPLICATION_EXCEPTION;
import static lotto.util.message.ErrorMessages.BONUS_NUMBER_RANGE_EXCEPTION;

import lotto.util.validator.NumberRangeValidator;

public class WinningNumbers {
    private final Lotto lotto;
    private final Integer bonusNumber;

    public WinningNumbers(Lotto lotto, Integer bonusNumber) {
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto lotto, Integer bonusNumber) {
        validateRange(bonusNumber);
        validateDuplication(lotto, bonusNumber);
    }

    private void validateRange(Integer bonusNumber) {
        if (NumberRangeValidator.isInvalidRange(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_RANGE_EXCEPTION);
        }
    }

    private void validateDuplication(Lotto lotto, Integer bonusNumber) {
        if (lotto.isContain(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATION_EXCEPTION);
        }
    }
}
