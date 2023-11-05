package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningResult {

    private Map<Ranking, Integer> rankingResult = new EnumMap<>(Ranking.class);
    private double returnRate;

    public WinningResult(List<Ranking> rankingResult, int purchasePrice) {
        Arrays.stream(Ranking.values())
                .forEach(ranking -> this.rankingResult.put(ranking, 0));

        rankingResult.stream()
                .forEach(ranking -> calculateRankingCount(ranking));

        returnRate = calculateReturnRate(purchasePrice);
    }

    private void calculateRankingCount(Ranking ranking) {

        if(rankingResult.get(ranking) > 0) {
            rankingResult.put(ranking, rankingResult.get(ranking) + 1);
        }

        if(rankingResult.get(ranking) <= 0) {
            rankingResult.put(ranking, 1);
        }
    }

    private double calculateReturnRate(int purchasePrice) {
        double totalReward = (double) Arrays.stream(Ranking.values())
                .mapToInt(ranking -> rankingResult.get(ranking) * ranking.getReward())
                .sum();
        return Math.round(((totalReward / purchasePrice * 100) * 10) / 10.0);
    }
}
