package lotto.model;

import java.util.Map;

public class Profit {

    public float calculateProfitRate(float buyAmount, Map<LottoRank, Integer> lottoRankInfo) {
        float winningPrice = calculateWinningPrice(lottoRankInfo);

        return (winningPrice / buyAmount) * 100;
    }


    public float calculateWinningPrice(Map<LottoRank, Integer> lottoRankInfo) {
        float profit = 0;

        profit += lottoRankInfo.get(LottoRank.FIFTH) * 5000;
        profit += lottoRankInfo.get(LottoRank.SECOND) * 50000;
        profit += lottoRankInfo.get(LottoRank.THIRD) * 150000;
        profit += lottoRankInfo.get(LottoRank.SECOND) * 30000000;
        profit += lottoRankInfo.get(LottoRank.FIRST) * 2000000000;

        return profit;
    }

}
