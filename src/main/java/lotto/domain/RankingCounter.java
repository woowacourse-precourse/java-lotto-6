package lotto.domain;


import java.util.EnumMap;
import java.util.Map;

public class RankingCounter {

    private static final int COUNTING = 1;
    private final Map<Ranking, Integer> rankingCounts;

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

    private void increaseCount(Ranking ranking) {
        rankingCounts.put(ranking, rankingCounts.getOrDefault(
                ranking, Unit.ZERO.getValue()) + COUNTING);
    }

    private void decreaseCount(Ranking ranking) {
        rankingCounts.put(ranking, rankingCounts.getOrDefault(
                ranking, Unit.ZERO.getValue()) - COUNTING);

    }

    public void increaseRankingCount(int rank) {
        for (Ranking ranking : Ranking.values()) {
            if (ranking.getRank() == rank) {
                increaseCount(ranking);
            }
        }
    }

    public int getCount(Ranking ranking) {
        return rankingCounts.get(ranking);
    }
}
