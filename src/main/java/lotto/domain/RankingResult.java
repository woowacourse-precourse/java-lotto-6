package lotto.domain;

import java.util.HashMap;

public class RankingResult {

    private HashMap<Ranking, Integer> result;

    public RankingResult() {
        this.result = new HashMap<>();

        for (Ranking ranking : Ranking.values()) {
            result.put(ranking, 0);
        }
    }

    public void updateResult(final Ranking ranking) {
        result.put(ranking, result.get(ranking) + 1);
    }

    public int findCountByRanking(final Ranking ranking) {
        return result.get(ranking);
    }

    public int calculateProfit() {
        int profit = 0;

        for (Ranking ranking : Ranking.values()) {
            int count = result.get(ranking);
            profit += Ranking.calculateProfitByRanking(ranking, count);
        }

        return profit;
    }
}
