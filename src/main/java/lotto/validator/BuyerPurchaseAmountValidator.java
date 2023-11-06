package lotto.validator;

import static lotto.exception.ErrorMessage.INVALID_PURCHASE_AMOUNT;

import lotto.exception.LottoException;

public class BuyerPurchaseAmountValidator implements Validator<Integer>{

    @Override
    public void validate(final Integer purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw LottoException.of(INVALID_PURCHASE_AMOUNT);
        }
    }
}
