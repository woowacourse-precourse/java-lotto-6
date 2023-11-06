package lotto.validator;

import static lotto.exception.ErrorMessage.INVALID_PURCHASE_AMOUNT;
import static lotto.exception.ErrorMessage.NOT_NUMERIC_PURCHASE_AMOUNT;

import lotto.exception.LottoException;

public class BuyerPurchaseAmountValidator implements Validator<String> {

    @Override
    public void validate(final String purchaseAmount) {
        validateNumeric(purchaseAmount);
        validateDivisibilityBy1000(purchaseAmount);
    }

    private void validateNumeric(String purchaseAmount) {
        try {
            Integer.valueOf(purchaseAmount);
        } catch (NumberFormatException e) {
            throw LottoException.of(NOT_NUMERIC_PURCHASE_AMOUNT);
        }
    }


    private void validateDivisibilityBy1000(String purchaseAmount) {
        if (Integer.parseInt(purchaseAmount) % 1000 != 0) {
            throw LottoException.of(INVALID_PURCHASE_AMOUNT);
        }
    }
}
