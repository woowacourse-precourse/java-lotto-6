package lotto.model;

public class Buyer {
    static final int LOTTO_PRICE=1000;
    private int purchaseAmount;

    private int LottoQuantity;

    public Buyer(int purchaseAmount){
        this.purchaseAmount=purchaseAmount;
        calculateQuantity(purchaseAmount);
    }

    private void calculateQuantity(int purchaseAmount){
        this.LottoQuantity=purchaseAmount/LOTTO_PRICE;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getLottoQuantity() {
        return LottoQuantity;
    }
}
