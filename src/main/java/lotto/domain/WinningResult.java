package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningResult {

    private final Map<Ranking, Integer> rankingCount = new EnumMap<>(Ranking.class);
    private double returnRate;

    public WinningResult(List<Ranking> rankingCount, int purchasePrice) {
        Arrays.stream(Ranking.values())
                .forEach(ranking -> this.rankingCount.put(ranking, 0));

        rankingCount.stream()
                .forEach(ranking -> calculateRankingCount(ranking));

        returnRate = calculateReturnRate(purchasePrice);
    }

    private void calculateRankingCount(Ranking ranking) {

        if(rankingCount.get(ranking) > 0) {
            rankingCount.put(ranking, rankingCount.get(ranking) + 1);
        }

        if(rankingCount.get(ranking) <= 0) {
            rankingCount.put(ranking, 1);
        }
    }

    private double calculateReturnRate(int purchasePrice) {
        double totalReward = Arrays.stream(Ranking.values())
                .mapToInt(ranking -> rankingCount.get(ranking) * ranking.getReward())
                .sum();
        return (totalReward / purchasePrice) * 100;
    }

    public Map<Ranking, Integer> getRankingCount() {
        return rankingCount;
    }

    public double getReturnRate() {
        return returnRate;
    }
}
