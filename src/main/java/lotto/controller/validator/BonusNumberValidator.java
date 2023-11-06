package lotto.controller.validator;

import lotto.utils.GameConstants;
import lotto.utils.Message;

public class BonusNumberValidator implements Validator {
    @Override
    public void validate(String bonusNumber) throws IllegalArgumentException {
        int numericBonusNumber = getNumericBonusNumber(bonusNumber);
        isInRange(numericBonusNumber);
    }

    public int getNumericBonusNumber(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.NON_NUMERIC_EXCEPTION_MESSAGE);
        }
    }

    public void isInRange(int bonusNumber) {
        if (bonusNumber < GameConstants.MIN_LOTTO_NUMBER) {
            throw new IllegalArgumentException(Message.OUT_OF_RANGE_EXCEPTION_MESSAGE);
        }
        if (bonusNumber > GameConstants.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(Message.OUT_OF_RANGE_EXCEPTION_MESSAGE);
        }
    }
}
