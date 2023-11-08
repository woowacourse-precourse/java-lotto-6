package lotto;

import java.util.Map;

public class LottoWinningResultSummary {

    private LottoResult lottoResult;
    private double grossProfitRate;

    public LottoWinningResultSummary(LottoResult lottoResult) {
        this.lottoResult = lottoResult;
        this.grossProfitRate = calcGrossProfitRate(lottoResult);
    }

    private long calcTotalPrize(LottoResult lottoResult) {
        long totalPrize = 0L;
        Map<LottoRank, Integer> rankResult = lottoResult.getRankResult();
        for (Map.Entry<LottoRank, Integer> rank : rankResult.entrySet()) {
            long prize = rank.getKey().getPrize();
            int count = rank.getValue();
            totalPrize += prize * count;
        }
        return totalPrize;
    }

    private int calcAmountSpent(LottoResult lottoResult) {
        int countPurchased = lottoResult.countPurchases();
        return countPurchased * LottoManagement.PRICE_LOTTO;
    }

    public double calcGrossProfitRate(LottoResult lottoResult) {
        long totalPrize = calcTotalPrize(lottoResult);
        int amountSpent = calcAmountSpent(lottoResult);
        return ((double) totalPrize / amountSpent) * 100;
    }

    public LottoResult getLottoResult() {
        return lottoResult;
    }

    public double getGrossProfitRate() {
        return grossProfitRate;
    }
}
