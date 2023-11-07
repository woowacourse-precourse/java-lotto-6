package lotto.service;

import lotto.domain.PurchasePrice;

public class PriceService {

    private static final int LOTTO_UNIT = 1000;

    private PurchasePrice purchasePrice;

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = new PurchasePrice(purchasePrice);
    }

    public int getLottoPurchaseQuantity() {
        return purchasePrice.getPurchasePrice() / LOTTO_UNIT;
    }

}
