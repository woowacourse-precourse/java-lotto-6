package lotto.domain;

import lotto.util.LottoConstants;

public class PurchaseAmount {
    private int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public void validatePurchaseAmount(int money) {
        if (money % LottoConstants.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
