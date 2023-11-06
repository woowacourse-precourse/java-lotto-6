package lotto.domain;

import java.util.*;

public class WinningResult {

    private final Map<Ranking, Integer> rankingCount = new EnumMap<>(Ranking.class);
    private double returnRate;

    public WinningResult(List<Ranking> rankings, int purchasePrice) {
        setInitialCondition();
        calculateWinningResult(rankings);
        calculateReturnRate(purchasePrice);
    }

    private void setInitialCondition() {
        Arrays.stream(Ranking.values())
                .forEach(ranking -> this.rankingCount.put(ranking, 0));
    }

    private void calculateWinningResult(List<Ranking> rankings) {
        rankings.stream()
                .forEach(ranking -> rankingCount.put(ranking, rankingCount.get(ranking) + 1));
    }

    private void calculateReturnRate(int purchasePrice) {
        double totalReward = Arrays.stream(Ranking.values())
                .mapToInt(ranking -> rankingCount.get(ranking) * ranking.getReward())
                .sum();
        returnRate = (totalReward / purchasePrice) * 100;
    }

    public Map<Ranking, Integer> getRankingCount() {
        return Collections.unmodifiableMap(rankingCount);
    }

    public double getReturnRate() {
        return returnRate;
    }
}
