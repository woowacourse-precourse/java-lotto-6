package lotto.domain;


public class Consumer {
    private int purchaseAmount;

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(int purchaseAmount) {
        LottoPrice.THOUSAND_WON.validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }
}
