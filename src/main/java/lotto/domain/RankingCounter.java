package lotto.domain;


import java.util.EnumMap;

import java.util.Map;


public class RankingCounter {

    private Map<Ranking, Integer> rankingCounts;

    public RankingCounter() {
        rankingCounts = new EnumMap<>(Ranking.class);
        for (Ranking ranking : Ranking.values()) {
            rankingCounts.put(ranking, Unit.ZERO.getValue());
        }
    }

    public void changeCountWhenHasBonusNumber() {
        increaseCount(Ranking.SECOND);
        decreaseCount(Ranking.THIRD);
    }


    public void increaseCount(Ranking ranking) {
        rankingCounts.put(ranking, rankingCounts.getOrDefault(ranking, 0) + 1);
    }

    public void decreaseCount(Ranking ranking) {
        rankingCounts.put(ranking, rankingCounts.getOrDefault(ranking, 0) - 1);

    }

    public void increaseRankingCount(int count) {
        for (Ranking ranking : Ranking.values()) {
            if (ranking.getRank() == count) {
                increaseCount(ranking);
            }
        }
    }

    public int getCount(Ranking ranking) {
        return rankingCounts.get(ranking);
    }
}
