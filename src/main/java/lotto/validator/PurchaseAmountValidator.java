package lotto.validator;

import lotto.Constant.ErrorMessage;
import lotto.Constant.PurchaseAmount;

public class PurchaseAmountValidator {

    public static int validate(String input) {
        try {
            int purchaseAmount = Integer.parseInt(input.trim());
            validateAmountIsAtLeastMinimum(purchaseAmount);
            validateAmountDivisibleByUnit(purchaseAmount);
            validateMaxAmount(purchaseAmount);
            return purchaseAmount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT.getMessage());
        }
    }

    private static void validateAmountIsAtLeastMinimum(int amount) {
        if (amount < PurchaseAmount.UNIT.getAmount()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MIN_AMOUNT.getMessage(PurchaseAmount.UNIT.getAmount()));
        }
    }

    private static void validateAmountDivisibleByUnit(int amount) {
        if (amount % PurchaseAmount.UNIT.getAmount() != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_UNIT_AMOUNT.getMessage(PurchaseAmount.UNIT.getAmount()));
        }
    }

    private static void validateMaxAmount(int amount) {
        if (amount > PurchaseAmount.MAX.getAmount()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MAX_AMOUNT.getMessage(PurchaseAmount.MAX.getAmount()));
        }
    }
}
