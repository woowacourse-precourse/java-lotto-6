package lotto.domain;

import lotto.exception.purchaseamount.PurchaseAmountDivideException;
import lotto.exception.purchaseamount.PurchaseAmountLimitException;

import static lotto.utils.LottoConstants.DIVIDE_UP_VALUE;
import static lotto.utils.LottoConstants.LOTTO_PRICE;

public class PurchaseAmount {

    private final int purchaseAmount;

    private PurchaseAmount(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public static PurchaseAmount from(int purchaseAmount) {
        return new PurchaseAmount(purchaseAmount);
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        validatePurchaseAmountUnderThousand(purchaseAmount);
        validatePurchaseAmountDivideByThousand(purchaseAmount);
    }

    private void validatePurchaseAmountDivideByThousand(int purchaseAmount) {
        if(purchaseAmount % LOTTO_PRICE.getConstants() != DIVIDE_UP_VALUE.getConstants()) {
            throw new PurchaseAmountDivideException();
        }
    }

    private void validatePurchaseAmountUnderThousand(int purchaseAmount) {
        if(purchaseAmount < LOTTO_PRICE.getConstants()) {
            throw new PurchaseAmountLimitException();
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
