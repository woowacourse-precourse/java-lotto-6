package lotto.domain;

import java.util.Map;

public class Statistics {
    private final Map<Prize, Integer> prizeResults;

    public  Statistics(Map<Prize, Integer> prizeResults) {
        this.prizeResults = prizeResults;
    }

    public double calculate(int money) {
        return sum(prizeResults) * 100 / money;
    }

    private double sum(Map<Prize, Integer> prizeResults) {
        return prizeResults.entrySet()
                .stream()
                .mapToDouble(prizeResult -> prizeResult.getKey().getReward() * prizeResult.getValue())
                .sum();
    }
}
