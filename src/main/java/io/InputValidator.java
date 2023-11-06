package io;

import static io.ValidationErrorMessages.*;
import static lotto.LottoConstants.LOTTO_PRICE;

public class InputValidator {

    public void validateLottoPurchaseAmount(String input) {
        int lottoPurchaseAmount;

        try {
            lottoPurchaseAmount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER.getMessage());
        }

        if (lottoPurchaseAmount < LOTTO_PRICE.getValue()) {
            throw new IllegalArgumentException(BELOW_MINIMUM_PURCHASE_AMOUNT.getMessage());
        }

        if (lottoPurchaseAmount % LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(NOT_MULTIPLE_OF_PRICE.getMessage());
        }
    }
}
