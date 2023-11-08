package lotto.domain;

import lotto.constant.PrizeCalculator;
import java.util.LinkedHashMap;
import java.util.Map;

public class GameResult {
    private final Map<Integer, Integer> winningCount;
    private long totalWinningAmount;
    private double profitMarginPercentage;

    public GameResult() {
        this.winningCount = new LinkedHashMap<>();
        addPrizeCount();
        this.totalWinningAmount = 0;
    }

    private void addPrizeCount() {
        winningCount.put(3, 0);
        winningCount.put(4, 0);
        winningCount.put(5, 0);
        winningCount.put(50, 0);
        winningCount.put(6, 0);
    }

    public Map<Integer, Integer> getWinningCountByRank() {
        return new LinkedHashMap<>(winningCount);
    }

    public double getProfitMarginPercentage() {
        return profitMarginPercentage;
    }

    public void incrementWinningCount(int number) {
        if (isRankValid(number)) {
            winningCount.put(number, winningCount.get(number) + 1);
        }
    }

    public void addTotalWinningAmount(int number) {
        PrizeCalculator.findPrizeMoney(number)
                .ifPresent(prize -> totalWinningAmount += prize);
    }

    private boolean isRankValid(int number) {
        return winningCount.containsKey(number);
    }

    public void calculateProfitMargin(int money) {
        profitMarginPercentage = ((double) totalWinningAmount / money) * 100;
    }
}
