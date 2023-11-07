package lotto.model;

public class PurchaseAmountLotto {
    private final int purchaseMoney;

    public PurchaseAmountLotto(int purchaseMoney) {
        this.purchaseMoney = purchaseMoney;
    }

    public int getPurchaseLotto() {
        return purchaseMoney / 1000;
    }
}
