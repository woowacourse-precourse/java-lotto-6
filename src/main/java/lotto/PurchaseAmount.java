package lotto;

public class PurchaseAmount {

    private long purchaseAmount;

    public PurchaseAmount(long purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public long getPurchaseAmount() {
        return this.purchaseAmount;
    }

    public int calculateNumberOfLotto() {
        return (int) purchaseAmount / 1000;
    }
}
