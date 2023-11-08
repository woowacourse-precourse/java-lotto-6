package lotto.model.lotto;

import static lotto.util.message.ErrorMessages.BONUS_RANGE_EXCEPTION;

import lotto.util.validator.NumberRangeValidator;

public class Bonus {
    private final Integer number;

    public Bonus(Integer number) {
        validate(number);
        this.number = number;
    }

    private void validate(Integer number) {
        validateRange(number);
    }

    private void validateRange(Integer bonusNumber) {
        if (NumberRangeValidator.isInvalidRange(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_RANGE_EXCEPTION);
        }
    }

    public Integer getNumber() {
        return number;
    }
}
