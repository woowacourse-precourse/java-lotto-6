package lotto.model;

import static lotto.util.ErrorMessage.*;

public class Purchase {

    private final int LOTTO_PRICE = 1000;
    private int purchaseAmount;
    private int purchaseNumber;

    public void setPurchase(int purchaseMoney) {
        validatePurchaseAmount(purchaseMoney);
        this.purchaseAmount = purchaseMoney;
        this.purchaseNumber = purchaseMoney / LOTTO_PRICE;
    }

    private void validatePurchaseAmount(int purchaseMoney) {
        if (purchaseMoney % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PURCHASE_AMOUNT_CANT_DIVIDE_BY_THOUSAND);
        }
        if (purchaseMoney == 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PURCHASE_AMOUNT_CANT_BE_ZERO);
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getPurchaseNumber() {
        return purchaseNumber;
    }


}
