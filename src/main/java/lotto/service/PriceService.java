package lotto.service;

import lotto.domain.PurchasePrice;

public class PriceService {

    private PurchasePrice purchasePrice;

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = new PurchasePrice(purchasePrice);
    }

}
