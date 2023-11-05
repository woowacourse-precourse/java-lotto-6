package lotto.model;

import lotto.constants.ErrorMessage;

public class InputValidation {
    public static int validatePurchaseAmount(String input) {
        if (!input.matches("[1-9]\\d*")) {
            handleInvalidNegativePurchase(input);
            handleInvalidZeroPurchase(input);
            throw new IllegalArgumentException(ErrorMessage.INVALID_NON_NUMERIC_PURCHASE.getMessage());
        }
        return Integer.parseInt(input);
    }

    public static int validateBonusNumber(String input) {
        try {
            int bonusNumber = Integer.parseInt(input);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NON_NUMERIC_PURCHASE.getMessage());
        }
    }

    private static void handleInvalidNegativePurchase(String input) {
        if (input.matches("[-]\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NEGATIVE_PURCHASE.getMessage());
        }
    }

    private static void handleInvalidZeroPurchase(String input) {
        if (input.matches("0+")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ZERO_PURCHASE.getMessage());
        }
    }
}
