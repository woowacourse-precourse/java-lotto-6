package lotto.model;

import java.util.List;
import java.util.Map;

public class Profit {

    private final static int NONE_PRIZE = 0;
    private final static int FIFTH_PRIZE = 5000;
    private final static int FOURTH_PRIZE = 50000;
    private final static int THIRD_PRIZE = 1500000;
    private final static int SECOND_PRIZE = 30000000;
    private final static int FIRST_PRIZE = 2000000000;
    private final static int PERCENTAGE = 100;


    private float profit;

    public float calculateProfitRate(float buyAmount, Map<LottoRank, Integer> lottoRankInfo) {
        float winningPrice = calculateWinningPrice(lottoRankInfo);

        return (winningPrice / buyAmount) * PERCENTAGE;
    }


    public float calculateWinningPrice(Map<LottoRank, Integer> lottoRankInfo) {

        List<Integer> prizes = List.of(NONE_PRIZE, FIFTH_PRIZE, FOURTH_PRIZE, THIRD_PRIZE, SECOND_PRIZE, FIRST_PRIZE);

        for (LottoRank lottoRank : LottoRank.values()) {
            profit += lottoRankInfo.get(lottoRank) * prizes.get(lottoRank.ordinal());
        }

        return profit;
    }

}
