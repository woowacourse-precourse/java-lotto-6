package lotto.model;

import lotto.view.message.Error;

public class PurchaseAmount {

    private Integer purchaseAmount;

    private PurchaseAmount(String input) {
        Integer parsedInput = toInteger(input);
    }

    public static PurchaseAmount create(String input) {
        return new PurchaseAmount(input);
    }

    private static Integer toInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.PURCHASE_AMOUNT_VALIDATION_ERROR.getMessage());
        }
    }
}
