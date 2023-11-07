package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class RankContainer {

    private Map<Rank, Integer> rankContainer;

    public RankContainer() {
        rankContainer = new EnumMap<Rank, Integer>(Rank.class);
        for (Rank rank : Rank.values()) {
            rankContainer.put(rank, 0);
        }
    }

    public void incRank(Rank rank) {
        rankContainer.put(rank, rankContainer.get(rank) + 1);
    }

    public Integer getRankContainer(Rank rank) {
        return rankContainer.get(rank);
    }

}
