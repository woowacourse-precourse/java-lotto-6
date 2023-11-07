package lotto.validation;

import lotto.system.Constants;
import lotto.system.ErrorMessage;

public class AmountValidation implements Validation {
    @Override
    public void check(String input) {
        checkNumeric(input);
        checkDivisibleByOneThousand(input);
        checkOutOfRange(input);
        checkPositive(input);
    }

    private void checkNumeric(String input) {
        if (checkIsNotNumeric(input)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMERIC);
        }
    }

    private void checkDivisibleByOneThousand(String input) {
        if (Long.parseLong(input) % Constants.MONEY_UNIT.getConstants() != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVISIBLE);
        }
    }

    private void checkOutOfRange(String input) {
        try {
            Long.parseLong(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_OUT_OF_RANGE);
        }
    }

    private void checkPositive(String input) {
        if (Long.parseLong(input) < 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE);
        }
    }

    private boolean checkIsNotNumeric(String input) {
        return !input.matches("^\\d+$");
    }
}
