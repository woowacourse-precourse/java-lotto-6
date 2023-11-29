package service;

import domain.PurchaseAmount;

public class PurchaseService {
    public PurchaseAmount createPurchaseAmount(final String purchaseAmount){
        return PurchaseAmount.create(purchaseAmount);
    }
}
