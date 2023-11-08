package lotto.domain;

import java.util.Map;
import java.util.stream.Collectors;

public record Result(Map<Rank, Integer> result) {
    public float calculateTotalRate() {
        return (float) getTotalPrize() / getTotalPrice() * 100;
    }

    private Integer getTotalPrize() {
        return result.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    private Integer getTotalPrice() {
        return result.values().stream()
                .mapToInt(Integer::intValue)
                .sum() * 1000;
    }

    public String calculateTotalRankStatus() {
        return result.entrySet().stream()
                .filter(entry -> entry.getKey() != Rank.NONE)
                .map(entry -> entry.getKey().calculateRankStatus(entry.getValue()))
                .collect(Collectors.joining("\n"));
    }
}
