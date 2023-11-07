package lotto.validation;

import lotto.system.Constants;
import lotto.system.ErrorMessage;

public class BonusValidation implements Validation {
    @Override
    public void check(String input) {
        checkNumberOutOfRange(input);
    }

    private void checkNumberOutOfRange(String input) {
        if (Integer.parseInt(input) < Constants.START_NUMBER.getConstants()
                || Integer.parseInt(input) > Constants.END_NUMBER.getConstants()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE);
        }
    }
}
