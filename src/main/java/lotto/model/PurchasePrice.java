package lotto.model;

import lotto.constant.ValidateMessage;

public class PurchasePrice {
    private final int purchasePrice;
    private final int count;

    public PurchasePrice(int purchasePrice) {
        isDIVIDEDBy1000(purchasePrice);
        isZero(purchasePrice);
        this.purchasePrice = purchasePrice;
        this.count = purchasePrice / 1000;
    }

    private void isDIVIDEDBy1000(int purchasePrice) {
        if (purchasePrice % 1000 != 0) {
            ValidateMessage.PURCHASE_PRICE_IS_NOT_DIVIDED_1000.throwException();
        }
    }

    private void isZero(int purchasePrice) {
        if (purchasePrice == 0) {
            ValidateMessage.PURCHASE_PRICE_CAN_NOT_BE_0.throwException();
        }
    }


    public int getPurchasePrice() {
        return purchasePrice;
    }

    public int getCount() {
        return count;
    }
}
