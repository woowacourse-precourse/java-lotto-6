package lotto.model;

public class Buyer {
    static final int LOTTO_PRICE=1000;
    private int purchaseAmount;

    private int lottoQuantity;

    public Buyer(int purchaseAmount){
        this.purchaseAmount=purchaseAmount;
        calculateQuantity(purchaseAmount);
    }

    private void calculateQuantity(int purchaseAmount){
        this.lottoQuantity =purchaseAmount/LOTTO_PRICE;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getLottoQuantity() {
        return lottoQuantity;
    }
}
