package lotto.domain;

import lotto.constant.LottoConstant;

public class PurchaseAmount {
    private final int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        validateIsDivideByLottoPrice(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validateIsDivideByLottoPrice(int purchaseAmount) {
        if (purchaseAmount % LottoConstant.LOTTO_PRICE.value() != 0) {
            throw new IllegalArgumentException();
        }
    }
}
