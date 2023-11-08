package lotto.validator;

import lotto.constants.ExceptionMessages;

public class UserInputValidator {

    public static int validatePurchaseAmount(String purchaseAmount) {
        int amount = checkIsNumericOnly(purchaseAmount);
        checkPurchaseAmount(amount);
        return amount;
    }

    private static int checkIsNumericOnly(String purchaseAmount) {
        try {
            return Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            String errorMessage = ExceptionMessages.PURCHASE_AMOUNT_TYPE_ERROR_MESSAGE.getErrorMessage();
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static void checkPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0 || purchaseAmount % 1000 != 0) {
            String errorMessage = ExceptionMessages.PURCHASE_AMOUNT_RANGE_ERROR_MESSAGE.getErrorMessage();
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
