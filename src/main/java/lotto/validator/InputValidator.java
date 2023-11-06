package lotto.validator;

import static lotto.validator.constants.ErrorType.*;

public class InputValidator {
    private static final int DIVISION_UNIT = 1000;

    public static int validateAmount(String amount) {
        int validateAmount = validateStringToInteger(amount);
        validateAmountFormat(validateAmount);
        return validateAmount;
    }

    private static int validateStringToInteger(String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(CAN_NOT_CONVERT_INTEGER_MESSAGE.getMessage());
        }
    }

    private static void validateAmountFormat(int amount) {
        if (amount % DIVISION_UNIT != 0) {
            throw new IllegalArgumentException(CAN_NOT_SATISFY_INTEGER_CONDITION.getMessage());
        }
    }
}
