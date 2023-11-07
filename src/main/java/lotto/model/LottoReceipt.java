package lotto.model;

public class LottoReceipt {
    private int amount;
    private int purchaseCount;

    public LottoReceipt(int amount, int purchaseCount) {
        this.amount = amount;
        this.purchaseCount = purchaseCount;
    }

    public int getAmount() {
        return amount;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }
}
