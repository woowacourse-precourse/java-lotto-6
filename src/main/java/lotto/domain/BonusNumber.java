package lotto.domain;

import lotto.exception.InvalidInputException;

import static lotto.utils.constants.BonusNumberConstants.*;


public class BonusNumber {
    private final Integer number;

    public BonusNumber(Integer number) {
        validate(number);
        this.number = number;
    }

    private void validate(Integer number) {
        if (!isCorrectNumberRange(number)) {
            throw new InvalidInputException(INVALID_BONUS_NUMBER_RANGE_MESSAGE);
        }
    }

    private boolean isCorrectNumberRange(Integer number) {
        return number < MIN_BONUS_NUMBER || number > MAX_BONUS_NUMBER;
    }

    public Integer getNumber() {
        return number;
    }
}
