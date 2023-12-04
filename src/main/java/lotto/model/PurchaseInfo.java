package lotto.model;


import static lotto.PlayLottoGame.validator;

public class PurchaseInfo {
    private final int purchaseCost;
    private final int purchaseCount;

    public PurchaseInfo(String purchaseCost){
        validator.validatePurchaseCost(purchaseCost);
        this.purchaseCost = Integer.parseInt(purchaseCost);
        this.purchaseCount = this.purchaseCost/1000;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }
}
