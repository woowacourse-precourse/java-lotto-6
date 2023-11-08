package lotto.model;

public class PurchaseInfo {
    private final int purchaseCost;
    private final int purchaseCount;

    public PurchaseInfo(Integer purchaseCost){
        this.purchaseCost = purchaseCost;
        this.purchaseCount = purchaseCost/1000;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }
}
