package lotto.domain;

import java.util.List;
import java.util.Map;

public class Results {

    private List<Result> results;

    public Results(List<Result> results) {
        this.results = results;
    }

    public double getProfit(int purchasePrice) {
        long totalPrize = this.getTotalPrize();
        return ((double) totalPrize / purchasePrice) * 100.0;
    }

    private long getTotalPrize() {
        return results.stream()
                .mapToLong(Result::getPrize)
                .sum();
    }

    public Map<Result, Integer> getStatistics() {
        Map<Result, Integer> statisticsBoard = Result.getDefaultStatisticsBoard();
        results.forEach(result -> {
            statisticsBoard.put(result, statisticsBoard.getOrDefault(result, 0) + 1);
        });
        return statisticsBoard;
    }
}
