package lotto.validation;

import lotto.utils.constants.Comment;
import lotto.utils.constants.ExceptionMessage;

public class InputValidation {

    public static String validatePurchaseAmountIsBlank(String purchaseAmount) {
        if (purchaseAmount == null || purchaseAmount.isBlank()) {
            throw new IllegalArgumentException(String.valueOf(ExceptionMessage.PURCHASE_AMOUNT_BLANK.getMessage()));
        }
        return purchaseAmount;
    }

    public static int validateInputPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < 1000 || purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(String.valueOf(ExceptionMessage.PURCHASE_AMOUNT_NOT_THOUSAND.getMessage()));
        }
        return purchaseAmount;
    }

    public static String validateInputString(String purchaseAmount) {
        if (!purchaseAmount.matches("\\d+")) {
            throw new IllegalArgumentException(String.valueOf(ExceptionMessage.PURCHASE_AMOUNT_NOT_NUMBER.getMessage()));
        }
        return purchaseAmount;
    }
}
