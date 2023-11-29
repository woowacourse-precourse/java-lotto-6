package domain;

public class PurchaseAmount {
    private final Amount amount;

    private PurchaseAmount(final String purchaseAmount){
        this.amount = Amount.create(purchaseAmount);
    }

    public static PurchaseAmount create(final String purchaseAmount){
        return new PurchaseAmount(purchaseAmount);
    }
}
