package lotto.validation;

import lotto.constant.ErrorMessage;
import lotto.constant.NumberUtil;

public class PurchaseAmountValidation {

    NumericInputValidation numericInputValidation = new NumericInputValidation();

    public int validatePurchaseAmount(String input) {
        numericInputValidation.validateInputIsNumeric(input);
        validateCheckRangeOfPurchaseAmountInput(input);
        int purchaseAmount = Integer.parseInt(input);
        validatePurchaseAmountIsPositive(purchaseAmount);
        validatePurchaseAmountOutOfRange(purchaseAmount);
        validatePurchaseAmountUnit(purchaseAmount);

        return purchaseAmount;
    }

    public void validateCheckRangeOfPurchaseAmountInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException(ErrorMessage
                    .MAX_PURCHASE_AMOUNT_CONSTRAINT_ERROR_MESSAGE
                    .getMessage());
        }
    }

    public void validatePurchaseAmountIsPositive(int purchaseAmount) {
        if (purchaseAmount < NumberUtil.MIN_NUMBER.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage
                    .POSITIVE_PURCHASE_AMOUNT_CONSTRAINT_ERROR_MESSAGE
                    .getMessage());
        }
    }

    public void validatePurchaseAmountOutOfRange(int purchaseAmount) {
        if (purchaseAmount > NumberUtil.MAX_NUMBER.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage
                    .PURCHASE_AMOUNT_LIMIT_CONSTRAINT_ERROR_MESSAGE
                    .getMessage());
        }
    }

    public void validatePurchaseAmountUnit(int purchaseAmount) {
        if (purchaseAmount == 0 || purchaseAmount % NumberUtil.LOTTO_PRICE.getNumber() != 0) {
            throw new IllegalArgumentException(ErrorMessage
                    .PURCHASE_AMOUNT_UNITS_CONSTRAINT_ERROR_MESSAGE
                    .getMessage());
        }
    }
}
