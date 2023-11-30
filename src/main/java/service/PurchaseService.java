package service;

import domain.PurchaseAmount;

public class PurchaseService {
    public PurchaseAmount createPurchaseAmount(final int purchaseAmount){
        return PurchaseAmount.create(purchaseAmount);
    }
}
