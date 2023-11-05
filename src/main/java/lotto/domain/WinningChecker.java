package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningChecker {
    private double totalWinningAmount;
    private Map<Integer, Integer> rankInfo;

    public WinningChecker() {
        this.totalWinningAmount = 0;
        this.rankInfo = new HashMap<>();
    }

    public static WinningChecker createWinningChecker() {
        return new WinningChecker();
    }

    public void checkWinning(Customer customer) {
        List<Result> results = customer.getResults();
        calculateTotalWinningAmount(results);
        calculateRank(results);
    }

    private void calculateTotalWinningAmount(List<Result> results) {
        for (Result result : results) {
            result.getWinningInfo()
                    .ifPresent(winningInfo -> this.totalWinningAmount += winningInfo.getAmount());
        }
    }

    private void calculateRank(List<Result> results) {
        for (Result result : results) {
            result.getWinningInfo()
                    .ifPresent(winningInfo -> addRankInfo(winningInfo.getRank()));
        }
    }

    private void addRankInfo(int rank) {
        this.rankInfo.put(rank, this.rankInfo.getOrDefault(rank, 0) + 1);
    }

    public Map<Integer, Integer> getRankInfo() {
        return this.rankInfo;
    }

    public double getTotalWinningAmount() {
        return this.totalWinningAmount;
    }
}
