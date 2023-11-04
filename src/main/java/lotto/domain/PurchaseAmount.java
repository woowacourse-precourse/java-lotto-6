package lotto.domain;

import lotto.view.ErrorMessage;

public class PurchaseAmount {

    private final int purchaseAmount;

    private PurchaseAmount(int purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public static PurchaseAmount from(int purchaseAmount) {
        return new PurchaseAmount(purchaseAmount);
    }

    private void validate(int purchaseAmount) {
        validateEnoughAmount(purchaseAmount);
        validateAmountInMultiplesOfPrice(purchaseAmount);
    }

    private void validateAmountInMultiplesOfPrice(int purchaseAmount) {
        if (purchaseAmount % LottoRule.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT.getErrorMessage());
        }
    }

    private void validateEnoughAmount(int purchaseAmount) {
        if (purchaseAmount < LottoRule.LOTTO_PRICE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ENOUGH_PURCHASE_AMOUNT.getErrorMessage());
        }
    }
}
