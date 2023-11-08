package lotto.domain;

import lotto.util.ExceptionMessage;
import lotto.util.LottoConstants;

public class PurchaseAmount {
    private int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public void validatePurchaseAmount(int money) {
        if (money % LottoConstants.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(
                    ExceptionMessage.NOT_ALLOW_PURCHASE_AMOUNT_UNIT_MESSAGE.getErrorMessage());
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
