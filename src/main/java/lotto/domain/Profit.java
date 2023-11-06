package lotto.domain;

public class Profit {
    private final LottoResult lottoResult;
    private final PurchasePrice purchasePrice;

    public Profit(LottoResult lottoResult, PurchasePrice purchasePrice) {
        this.lottoResult = lottoResult;
        this.purchasePrice = purchasePrice;
    }

    public static Profit of(LottoResult lottoResult, PurchasePrice purchasePrice) {
        return new Profit(lottoResult, purchasePrice);
    }

    public double getRateOfReturn() {
        return (lottoResult.calculateTotalPrize() / (double) purchasePrice.getPrice()) * 100;
    }
}
