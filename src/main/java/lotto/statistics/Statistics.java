package lotto.statistics;

import java.util.List;
import java.util.Map;
import lotto.money.LottoMoney;
import lotto.ranking.Ranking;

public class Statistics {

    private static final int INITIAL_TOTAL_PRIZE = 0;

    private final LottoResult statistics;

    public Statistics(List<Ranking> rankings) {
        this.statistics = new LottoResult(rankings);
    }


    public Map<Ranking, Integer> getStatistics() {
        return statistics.getLottoResult();
    }

    public Double calculateProfit(LottoMoney lottoMoney) {
        return lottoMoney.calculateProfit(getTotalPrize());
    }

    private Integer getTotalPrize() {
        int prize = INITIAL_TOTAL_PRIZE;
        for (Ranking ranking : Ranking.values()) {
            prize += ranking.calculatePrize(statistics.getRankingCount(ranking));
        }
        return prize;
    }
}
