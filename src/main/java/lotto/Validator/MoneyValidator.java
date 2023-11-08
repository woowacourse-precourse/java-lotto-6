package lotto.Validator;

import lotto.Exception.MoneyErrorMessage;

public class MoneyValidator {

    public static String validatePurchaseAmount(String input) {
        validateNotEmpty(input);

        return input;
    }

    private static void validateNotEmpty(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(MoneyErrorMessage.INVALID_MONEY_INPUT.getMessage());
        }
    }

}
