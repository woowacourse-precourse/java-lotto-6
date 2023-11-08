package lotto.model;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoNumConstant;
import lotto.validator.PurchaseAmountValidator;

public class PurchaseAmount {
    private final int purchaseAmount;

    private PurchaseAmount(int purchaseAmount) {
        PurchaseAmountValidator.isOverMinPurchaseAmount(purchaseAmount);
        PurchaseAmountValidator.isThousandWonAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public static PurchaseAmount getInstance(int purchaseAmount) {
        return new PurchaseAmount(purchaseAmount);
    }

    public int getLottoNum() {
        return purchaseAmount / LottoNumConstant.LOTTO_AMOUNT_UNIT.getValue();
    }
    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
