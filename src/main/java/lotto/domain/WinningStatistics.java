package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class WinningStatistics {
    private final Map<Ranking, Integer> rankingCounts;

    public WinningStatistics
            () {
        rankingCounts = new EnumMap<>(Ranking.class);
        for (Ranking ranking : Ranking.values()) {
            rankingCounts.put(ranking, 0);
        }
    }

    public void addRanking(Ranking ranking) {
        rankingCounts.put(ranking, rankingCounts.getOrDefault(ranking, 0) + 1);
    }

    public int getRankingCount(Ranking ranking) {
        return rankingCounts.getOrDefault(ranking, 0);
    }

    public double calculatePrizeMoney(){
        int totalPrizeMoney = 0;

        for (Map.Entry<Ranking, Integer> entry : rankingCounts.entrySet()) {
            Ranking ranking = entry.getKey();
            int count = entry.getValue();
            totalPrizeMoney += ranking.getPrize() * count;
        }

        return totalPrizeMoney;
    }
    public double calculateYield(int amount){
        return calculatePrizeMoney() /amount *100;
    }
}
