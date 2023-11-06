package lotto.domain;


public class Profit {
    private static final double PERCENTAGE = 100.0;
    private final LottoResult lottoResult;

    public Profit(LottoResult lottoResult) {
        this.lottoResult = lottoResult;
    }

    public double getRateOfReturn() {
        return (lottoResult.calculateTotalPrize() / (double) lottoResult.getPurchasePrice()) * PERCENTAGE;
    }
}
