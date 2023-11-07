package lotto.model;

import lotto.model.enums.LottoSpec;

public class PurchaseAmount {
    private int purchaseMoney;

    public PurchaseAmount(int purchaseMoney) {
        validatePurchaseMoney(purchaseMoney);
        this.purchaseMoney = purchaseMoney;
    }

    private void validatePurchaseMoney(int amount) {
        if (amount % LottoSpec.PRICE.getValue() != 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getPurchaseMoney() {
        return purchaseMoney;
    }


    public int getTicketNumber() {
        return purchaseMoney / LottoSpec.PRICE.getValue();
    }
}
