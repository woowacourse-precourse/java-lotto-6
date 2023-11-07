package lotto.model;

import java.util.Map;
import lotto.vo.BuyAmount;

public class ProfitRate {

    private static final Integer PERCENTAGE = 100;

    private final Double rate;

    private ProfitRate(final Double rate) {
        this.rate = rate;
    }

    public static ProfitRate createProfitRate(final Map<LottoRank, Integer> result, final BuyAmount buyAmount) {
        return new ProfitRate(calculateProfitRate(result, buyAmount));
    }

    private static Double calculateProfitRate(final Map<LottoRank, Integer> result, final BuyAmount buyAmount) {
        double reward = result.keySet()
                .stream()
                .mapToDouble(lottoRank -> calculateEachRankReward(result, lottoRank))
                .sum();

        return (reward / (double) buyAmount.amount()) * PERCENTAGE;
    }

    private static Long calculateEachRankReward(Map<LottoRank, Integer> result, LottoRank lottoRank) {
        return lottoRank.getPrizeMoney() * result.get(lottoRank);
    }

    public Double getRate() {
        return rate;
    }
}
