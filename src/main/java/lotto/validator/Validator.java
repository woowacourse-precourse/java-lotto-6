package lotto.validator;

import static lotto.constants.SystemOption.PAYMENT_UNIT_SYSTEM_VALUE;
import static lotto.message.ErrorMessage.*;

public class Validator {
    public void validatePayment(String userInput) {
        int payment = parseAndValidateInteger(userInput);
        validatePositive(payment);
        validateUnit(payment);
    }

    private int parseAndValidateInteger(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE.toString());
        }
    }

    private void validatePositive(int payment) {
        if (payment <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_ERROR_MESSAGE.toString());
        }
    }

    private void validateUnit(int payment) {
        if (payment % PAYMENT_UNIT_SYSTEM_VALUE.getValue() != 0) {
            throw new IllegalArgumentException(WRONG_UNIT_ERROR_MESSAGE.toString());
        }
    }

}
