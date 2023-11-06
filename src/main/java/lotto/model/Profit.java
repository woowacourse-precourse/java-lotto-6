package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Profit {

    public float calculateProfitRate(float buyAmount, Map<LottoRank, Integer> lottoRankInfo) {
        float winningPrice = calculateWinningPrice(lottoRankInfo);

        return (winningPrice / buyAmount) * 100;
    }


    public float calculateWinningPrice(Map<LottoRank, Integer> lottoRankInfo) {
        float profit = 0;

        List<Integer> prizes = List.of(0,5000, 50000, 150000, 30000000, 2000000000);

        for (LottoRank lottoRank : LottoRank.values()) {
            profit += lottoRankInfo.get(lottoRank) * prizes.get(lottoRank.ordinal());
        }

        return profit;
    }

}
