package domain;

public class PurchaseAmount {
    private static PurchaseAmount instance;
    private int purchaseAmount;

    private PurchaseAmount() {
    }

    public static PurchaseAmount getInstance() {
        if (instance == null) {
            instance = new PurchaseAmount();
        }
        return instance;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }
}
