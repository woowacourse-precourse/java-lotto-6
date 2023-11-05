package lotto.validation;

import static lotto.constants.ErrorMessage.*;

public class PurchaseAmountValidator {

    private static final Integer LOTTO_PRICE = 1000;

    public void validatePurchaseAmount(String purchaseAmount) {
        validateEmpty(purchaseAmount);
        validateBlank(purchaseAmount);
        validateOverZero(purchaseAmount);
        validateDivisibleByThousand(purchaseAmount);
    }

    private void validateBlank(String purchaseAmount) {
        if (purchaseAmount.isBlank()) {
            throw new IllegalArgumentException(BLANK_NOT_ALLOWED.toString());
        }
    }

    private void validateEmpty(String purchaseAmount) {
        if (purchaseAmount.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_NOT_ALLOWED.toString());
        }
    }

    private void validateDivisibleByThousand(String purchaseAmount) {
        Integer validatedIntegerPurchaseAmount = validateInteger(purchaseAmount);
        if ((validatedIntegerPurchaseAmount % LOTTO_PRICE) != 0) {
            throw new IllegalArgumentException(DIVISIBLE_BY_THOUSAND_ALLOWED.toString());
        }
    }


    private void validateOverZero(String purchaseAmount) {
        Integer validatedIntegerPurchaseAmount = validateInteger(purchaseAmount);
        if (validatedIntegerPurchaseAmount <= 0) {
            throw new IllegalArgumentException(ZERO_OR_LESS_NOT_ALLOWED.toString());
        }
    }

    private Integer validateInteger(String purchaseAmount) {
        try {
            return Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ONLY_NUMBER_ALLOWED.toString());
        }
    }
}
