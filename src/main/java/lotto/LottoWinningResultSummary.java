package lotto;

import java.util.Map;

public class LottoWinningResultSummary {

    private LottoResult lottoResult;
    private double grossProfitRate;

    public LottoWinningResultSummary(LottoResult lottoResult) {
        this.lottoResult = lottoResult;

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


}
