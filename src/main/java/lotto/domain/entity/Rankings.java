package lotto.domain.entity;

import java.util.EnumMap;
import java.util.Map;

public class Rankings {

    private final Map<Ranking, Integer> rankings = new EnumMap<>(Ranking.class);

    private Rankings() {
        init();
    }

    public static Rankings create() {
        return new Rankings();
    }

    private void init() {
        for (Ranking rank : Ranking.values()) {
            rankings.put(rank, 0);
        }
    }

    public void addRankings(Ranking ranking) {
        rankings.put(ranking, rankings.get(ranking) + 1);
    }

    public Map<Ranking, Integer> getRankings() {
        return rankings;
    }
}