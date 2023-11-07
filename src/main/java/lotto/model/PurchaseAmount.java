package lotto.model;

public class PurchaseAmount {
    private int purchaseMoney;

    public PurchaseAmount(int purchaseMoney) {
        validatePurchaseMoney(purchaseMoney);
        this.purchaseMoney = purchaseMoney;
    }

    private void validatePurchaseMoney(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getPurchaseMoney() {
        return purchaseMoney;
    }


}
