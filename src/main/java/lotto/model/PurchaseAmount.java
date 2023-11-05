package lotto.model;

public class PurchaseAmount {
    private static final int LOTTO_PRICE = 1000;
    private final int purchaseAmount;

    public PurchaseAmount(int inputMoney) {
        this.purchaseAmount = inputMoney;
    }

    public int getMaxLottoCountForBudget() {
        return this.purchaseAmount / LOTTO_PRICE;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

}
