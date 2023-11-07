package lotto.validator;

import lotto.constant.message.ErrorMessage;
import lotto.constant.PurchaseAmount;

public class PurchaseAmountValidator {

    private PurchaseAmountValidator() {}

    public static long validate(String purchaseAmountInput) {
        isNumeric(purchaseAmountInput);
        long purchaseAmount = Long.parseLong(purchaseAmountInput.trim());
        validateAmountIsAtLeastMinimum(purchaseAmount);
        validateAmountDivisibleByUnit(purchaseAmount);
        validateMaxAmount(purchaseAmount);
        return purchaseAmount;
    }

    private static void isNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw new NumberFormatException(ErrorMessage.INVALID_AMOUNT.getMessage());
        }
    }

    private static void validateAmountIsAtLeastMinimum(long amount) {
        if (amount < PurchaseAmount.UNIT.getAmount()) {
            throw new IllegalArgumentException(
                    ErrorMessage.INVALID_MIN_AMOUNT.getMessage(PurchaseAmount.UNIT.getAmount()));
        }
    }

    private static void validateAmountDivisibleByUnit(long amount) {
        if (amount % PurchaseAmount.UNIT.getAmount() != 0) {
            throw new IllegalArgumentException(
                    ErrorMessage.INVALID_UNIT_AMOUNT.getMessage(PurchaseAmount.UNIT.getAmount()));
        }
    }

    private static void validateMaxAmount(long amount) {
        if (amount > PurchaseAmount.MAX.getAmount()) {
            throw new IllegalArgumentException(
                    ErrorMessage.INVALID_MAX_AMOUNT.getMessage(PurchaseAmount.MAX.getAmount()));
        }
    }
}
