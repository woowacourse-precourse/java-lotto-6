package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private static final Integer DEFAULT_VALUE = 1;

    private final Map<Ranking, Integer> results;

    public LottoResult(List<Lotto> lottoBundle, WinLotto winLotto) {
        Map<Ranking, Integer> results = calculateResults(lottoBundle, winLotto);
        this.results = results;
    }

    private Map<Ranking, Integer> calculateResults(List<Lotto> lottoBundle, WinLotto winLotto) {
        Map<Ranking, Integer> results = new HashMap<>();

        for (Lotto lotto : lottoBundle) {
            Ranking ranking = lotto.matchWithWinLotto(winLotto);
            updateRankingCount(results, ranking);
        }

        return results;
    }

    private void updateRankingCount(Map<Ranking, Integer> results, Ranking ranking) {
        results.put(ranking, findValueOrDefault(results, ranking) + 1);
    }

    private static Integer findValueOrDefault(Map<Ranking, Integer> results, Ranking ranking) {
        return results.getOrDefault(ranking, DEFAULT_VALUE);
    }

    public Double calculateEarningRatio(Money money) {
        long totalPrizeAmount = getTotalPrizeAmount();
        double earningRatio = (totalPrizeAmount / (double) money.getAmount()) * 100;
        return earningRatio;
    }

    private long getTotalPrizeAmount() {
        return results.entrySet().stream()
                .filter(entry -> entry.getKey() != null)
                .mapToLong(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
    }

    public Map<Ranking, Integer> getResults() {
        return results;
    }
}
