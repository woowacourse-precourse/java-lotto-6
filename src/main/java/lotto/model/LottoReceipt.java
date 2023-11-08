package lotto.model;

public class LottoReceipt {
    private int amount;
    private int purchaseCount;

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPurchaseCount(int purchaseCount) {
        this.purchaseCount = purchaseCount;
    }

    public int getAmount() {
        return amount;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }
}
