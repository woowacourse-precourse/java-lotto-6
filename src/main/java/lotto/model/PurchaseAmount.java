package lotto.model;

public class PurchaseAmount {
    private int purchaseAmount;

    private PurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public static PurchaseAmount getInstance(int purchaseAmount) {
        return new PurchaseAmount(purchaseAmount);
    }
}
