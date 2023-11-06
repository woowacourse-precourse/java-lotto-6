package lotto.validator;

import static lotto.validator.ErrorMessage.*;

public class BonusNumberValidator {
    private static final int MIN_BONUS_NUMBER = 1;
    private static final int MAX_BONUS_NUMBER = 45;

    public void validate(String input) {
        isBonusNumberNumeric(input);
        isBonusNumberInRange(input);
    }

    private void isBonusNumberInRange(String bonusNumber) {
        int number = Integer.parseInt(bonusNumber);
        if (number < MIN_BONUS_NUMBER || MAX_BONUS_NUMBER < number) {
            throw new IllegalArgumentException(BONUS_NUMBER_NOT_IN_RANGE_MESSAGE);
        }
    }

    private void isBonusNumberNumeric(String bonusNUmber) {
        try {
            Integer.parseInt(bonusNUmber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BONUS_NUMBER_IS_NOT_NUMERIC_MESSAGE);
        }
    }
}
