package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PrizeResult {
    private final Map<Ranking, Integer> prizeResult = new LinkedHashMap<>();

    public PrizeResult(List<Ranking> rankings) {
        initialMap();
        putValues(rankings);
    }

    private void putValues(List<Ranking> rankings) {
        for (Ranking ranking : rankings) {
            prizeResult.put(ranking, prizeResult.get(ranking) + 1);
        }
    }

    public long calculatePrizeSum() {
        long sum = 0;
        for (Map.Entry<Ranking, Integer> entry : prizeResult.entrySet()) {
            sum += entry.getKey().calculate(entry.getValue());
        }
        return sum;
    }

    private void initialMap() {
        List<Ranking> sortedRankings = Ranking.sortByPrize();
        for (Ranking ranking : sortedRankings) {
            prizeResult.put(ranking, 0);
        }
    }
    public Map<Ranking, Integer> getPrizeResult() {
        return prizeResult;
    }
}