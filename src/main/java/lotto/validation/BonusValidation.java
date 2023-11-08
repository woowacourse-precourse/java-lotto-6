package lotto.validation;

import lotto.system.Constants;
import lotto.system.ErrorMessage;

public class BonusValidation implements Validation {
    @Override
    public void check(final String input) {
        checkNumeric(input);
        checkNumberOutOfRange(input);
    }

    private void checkNumeric(final String input) {
        if (checkIsNotNumeric(input)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMERIC);
        }
    }

    private void checkNumberOutOfRange(final String input) {
        if (Integer.parseInt(input) < Constants.START_NUMBER.getConstants()
                || Integer.parseInt(input) > Constants.END_NUMBER.getConstants()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE);
        }
    }

    private boolean checkIsNotNumeric(final String input) {
        return !input.matches("^-?\\d+$");
    }
}
