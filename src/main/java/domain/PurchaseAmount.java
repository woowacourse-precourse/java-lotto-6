package domain;

import Constants.PurchaseAmountConstant;
import domain.wrapper.Amount;

public class PurchaseAmount {
    private final Amount amount;
    private final int quantity;

    private PurchaseAmount(final String purchaseAmount){
        this.amount = Amount.create(purchaseAmount);
        this.quantity = calculatequantity();
    }

    public int getQuantity(){
        return quantity;
    }

    public static PurchaseAmount create(final String purchaseAmount){
        return new PurchaseAmount(purchaseAmount);
    }

    private int calculatequantity(){
        return amount.getAmount() / PurchaseAmountConstant.ONE_THOUSAND.getValue();
    }
}
