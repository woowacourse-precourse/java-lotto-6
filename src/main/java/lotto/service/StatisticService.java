package lotto.service;

import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoPrize;
import lotto.model.LottoStatistic;

public class StatisticService {

    public LottoStatistic calculateLottoStatistics(Map<Lotto, LottoPrize> results) {
        LottoStatistic lottoStatistic = new LottoStatistic();
        results.values().forEach(prize -> {
            if (prize != null) {
                lottoStatistic.addStatistic(prize);
            }
        });
        return lottoStatistic;
    }

    public double calculateYield(Map<Lotto, LottoPrize> results, int lottoPrice) {
        double totalPrice = results.size() * lottoPrice;
        double totalPrize = results.values().stream()
                                    .filter(prize -> prize != null)
                                    .mapToDouble(LottoPrize::getPrize)
                                    .sum();
        double yield = (totalPrize / totalPrice) * 100;
        return Math.round(yield * 100.0) / 100.0;
    }
}
