package lotto.domain.entity;

import java.util.EnumMap;
import java.util.Map;

public class Rankings {

    private final Map<Ranking, Integer> rankings = new EnumMap<>(Ranking.class);

    private Rankings() {
        init();
    }

    private void init() {
        for (Ranking rank : Ranking.values()) {
            rankings.put(rank, 0);
        }
    }

    public static Rankings create() {
        return new Rankings();
    }

    public Map<Ranking, Integer> getRankings() {
        return rankings;
    }
}