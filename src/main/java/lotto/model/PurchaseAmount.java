package lotto.model;

import lotto.constant.ErrorMessage;
import lotto.validator.PurchaseAmountValidator;

public class PurchaseAmount {
    private static final int LOTTO_AMOUNT_UNIT = 1000;
    private int purchaseAmount;

    private PurchaseAmount(int purchaseAmount) throws IllegalArgumentException{
        // 여기서 1000원 단위의 유효성 검사 해야함
        if(!PurchaseAmountValidator.isOverMinPurchaseAmount(purchaseAmount)) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_ERROR.getMessage());
        }
        if(!PurchaseAmountValidator.isThousandWonAmount(purchaseAmount)) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_UNIT_ERROR.getMessage());
        }
        this.purchaseAmount = purchaseAmount;
    }

    public static PurchaseAmount getInstance(int purchaseAmount) throws IllegalArgumentException{
        return new PurchaseAmount(purchaseAmount);
    }

    public int getLottoNum() {
        return purchaseAmount / LOTTO_AMOUNT_UNIT;
    }
}
