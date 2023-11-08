package lotto.domain;

import java.util.Map;

public class Result {
    private final Map<Ranking, Integer> result;

    public Result(Map<Ranking, Integer> result) {
        this.result = result;
    }

    public double getRateOfReturn(int money) {
        long totalPrize = getTotalPrize();
        return (totalPrize / (double) money) * 100;
    }

    private long getTotalPrize() {
        return result.entrySet()
                .stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}
