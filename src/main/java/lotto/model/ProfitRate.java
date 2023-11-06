package lotto.model;

import java.util.Map;
import lotto.vo.BuyAmount;

public class ProfitRate {

    private static final Integer PERCENTAGE = 100;

    private final Double rate;

    private ProfitRate(final Double rate) {
        this.rate = rate;
    }

    public static ProfitRate from(final Map<LottoRank, Integer> result, final BuyAmount buyAmount) {
        return new ProfitRate(calculateRateOfProfit(result, buyAmount));
    }

    public static Double calculateRateOfProfit(final Map<LottoRank, Integer> result, final BuyAmount buyAmount) {
        double reward = result.keySet()
                .stream()
                .mapToDouble(lottoRank -> (lottoRank.getPrizeMoney() * result.get(lottoRank)))
                .sum();

        return (reward / (double) buyAmount.amount()) * PERCENTAGE;
    }

    public Double getRate() {
        return rate;
    }
}
