package lotto.lottoGame.rank;

import java.util.HashMap;
import java.util.Map;

public class RankCounter {
    private final Map<Rank, Integer> rankCounts;

    public RankCounter() {
        this.rankCounts = new HashMap<>();
        init(rankCounts);
    }

    private void init(Map<Rank, Integer> rankCounts) {
        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            rankCounts.put(rank, 0);
        }
    }

    public void addCount(Rank rank) {
        if (!rankCounts.containsKey(rank)) {
            rankCounts.put(rank, 0);
        }
        Integer crtCounts = rankCounts.get(rank);
        rankCounts.put(rank, crtCounts + 1);
    }

    public Map<Rank, Integer> getRankCounts() {
        return rankCounts;
    }

    public int getRankCount(Rank rank) {
        return rankCounts.get(rank);
    }
}
