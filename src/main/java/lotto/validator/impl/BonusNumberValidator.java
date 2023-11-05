package lotto.validator.impl;

import lotto.constants.ErrorMessages;
import lotto.validator.Validator;

public class BonusNumberValidator implements Validator<String> {
    @Override
    public void validate(String data) {
        isNumeric(data);
        isInRange(data);
    }

    private void isNumeric(String data) {
        try {
            Integer.parseInt(data);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_BONUS_NUMBER_NUMERIC.getMessage());
        }
    }

    private void isInRange(String data) {
        if (Integer.parseInt(data) < 1 || Integer.parseInt(data) > 45) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_BONUS_NUMBER_RANGE.getMessage());
        }
    }

}
