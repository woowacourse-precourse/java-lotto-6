package lotto.model;

import lotto.model.constant.LottoConstant;

public class Buyer {
    private int purchaseAmount;

    private int lottoQuantity;

    public Buyer(int purchaseAmount){
        this.purchaseAmount=purchaseAmount;
        calculateQuantity(purchaseAmount);
    }

    private void calculateQuantity(int purchaseAmount){
        this.lottoQuantity =purchaseAmount/ LottoConstant.LOTTO_PRICE.getConstant();
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getLottoQuantity() {
        return lottoQuantity;
    }
}
