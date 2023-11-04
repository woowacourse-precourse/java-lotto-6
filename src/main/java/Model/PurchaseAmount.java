package Model;

public class PurchaseAmount {
    private int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validate(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public int get() {
        return purchaseAmount;
    }
}
