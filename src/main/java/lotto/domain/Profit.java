package lotto.domain;

public class Profit {
    private final LottoResult lottoResult;

    public Profit(LottoResult lottoResult) {
        this.lottoResult = lottoResult;
    }

    public double getRateOfReturn() {
        return (lottoResult.calculateTotalPrize() / (double) lottoResult.getPurchasePrice()) * 100;
    }
}
