package lotto.domain;

import static lotto.error.ErrorMessage.NEGATIVE_PURCHASE_AMOUNT;
import static lotto.error.ErrorMessage.NOT_DIVIDED_PURCHASE_AMOUNT;

public class Validator {

    public void validatePurchaseAmount(Integer purchaseAmount) {
        validatePositiveNumber(purchaseAmount, NEGATIVE_PURCHASE_AMOUNT);
        validateDivided(purchaseAmount, NOT_DIVIDED_PURCHASE_AMOUNT);
    }


    private void validatePositiveNumber(Integer number, String error) {
        if (number <= 0) {
            throw new IllegalArgumentException(error);
        }
    }

    private void validateDivided(Integer number, String error) {
        if (number <= 0) {
            throw new IllegalArgumentException(error);
        }
    }

}
