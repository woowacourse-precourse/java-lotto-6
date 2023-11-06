package lotto.validator;

import static lotto.domain.constants.LottoConfig.LOTTO_UNIT_PRICE;
import static lotto.exception.ErrorMessage.INVALID_PURCHASE_AMOUNT;
import static lotto.exception.ErrorMessage.NOT_NUMERIC_PURCHASE_AMOUNT;

import lotto.exception.LottoException;

public class BuyerPurchaseAmountValidator implements Validator<String> {

    @Override
    public void validate(final String purchaseAmount) {
        validateNumeric(purchaseAmount);
        validateDivisibilityByUnitPrice(purchaseAmount);
    }

    private void validateNumeric(String purchaseAmount) {
        try {
            Integer.valueOf(purchaseAmount);
        } catch (NumberFormatException e) {
            throw LottoException.of(NOT_NUMERIC_PURCHASE_AMOUNT);
        }
    }


    private void validateDivisibilityByUnitPrice(String purchaseAmount) {
        if (Integer.parseInt(purchaseAmount) % LOTTO_UNIT_PRICE.getValue() != 0) {
            throw LottoException.of(INVALID_PURCHASE_AMOUNT);
        }
    }
}
