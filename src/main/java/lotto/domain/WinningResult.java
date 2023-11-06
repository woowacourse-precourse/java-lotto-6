package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningResult {

    private final Map<Ranking, Integer> winningResult = new EnumMap<>(Ranking.class);
    private double returnRate;

    public WinningResult(List<Ranking> rankings, int purchasePrice) {
        setInitialCondition();
        calculateWinningResult(rankings);
        calculateReturnRate(purchasePrice);
    }

    private void setInitialCondition() {
        Arrays.stream(Ranking.values())
                .forEach(ranking -> this.winningResult.put(ranking, 0));
    }

    private void calculateWinningResult(List<Ranking> rankings) {
        rankings.stream()
                .forEach(ranking -> winningResult.put(ranking, winningResult.get(ranking) + 1));
    }

    private void calculateReturnRate(int purchasePrice) {
        double totalReward = Arrays.stream(Ranking.values())
                .mapToInt(ranking -> winningResult.get(ranking) * ranking.getReward())
                .sum();
        returnRate = (totalReward / purchasePrice) * 100;
    }

    public Map<Ranking, Integer> getWinningResult() {
        return winningResult;
    }

    public double getReturnRate() {
        return returnRate;
    }
}
