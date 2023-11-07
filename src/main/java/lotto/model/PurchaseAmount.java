package lotto.model;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoNumConstant;
import lotto.validator.PurchaseAmountValidator;

public class PurchaseAmount {
    private int purchaseAmount;

    private PurchaseAmount(int purchaseAmount) {
        if(!PurchaseAmountValidator.isOverMinPurchaseAmount(purchaseAmount)) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_ERROR.getMessage());
        }
        if(!PurchaseAmountValidator.isThousandWonAmount(purchaseAmount)) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_UNIT_ERROR.getMessage());
        }
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
