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
}
