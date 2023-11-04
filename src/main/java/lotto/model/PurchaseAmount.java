package lotto.model;

import lotto.view.message.Error;

public class PurchaseAmount {

    private Integer purchaseAmount;

    private PurchaseAmount(String input) {
        Integer parsedInput = toInteger(input);
        checkPositive(parsedInput);
        checkThousandMultiple(parsedInput);
        purchaseAmount = parsedInput;
    }

    public static PurchaseAmount validate(String input) {
        return new PurchaseAmount(input);
    }

    private static Integer toInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.PURCHASE_AMOUNT_VALIDATION_ERROR.getMessage());
        }
    }

    private void checkPositive(Integer parsedInput) {
        if (parsedInput <= 0) {
            throw new IllegalArgumentException(Error.PURCHASE_AMOUNT_VALIDATION_ERROR.getMessage());
        }
    }

    private void checkThousandMultiple(Integer parsedInput) {
        if (parsedInput % 1000 != 0) {
            throw new IllegalArgumentException(Error.PURCHASE_AMOUNT_VALIDATION_ERROR.getMessage());
        }
    }

    public Integer getPurchaseAmount() {
        return purchaseAmount;
    }
}
