package io;

import static io.ValidationErrorMessages.*;

public class InputValidator {

    public void validateLottoPurchaseAmount(String input) {
        int lottoPurchaseAmount;

        try {
            lottoPurchaseAmount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER.getMessage());
        }

        if (lottoPurchaseAmount < 1000) {
            throw new IllegalArgumentException(BELOW_MINIMUM_PURCHASE_AMOUNT.getMessage());
        }

        if (lottoPurchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(NOT_MULTIPLE_OF_PRICE.getMessage());
        }
    }
}
