package lotto;

import java.util.Map;
import java.util.stream.Collectors;

public record Result(Map<Rank, Integer> result) {
    public String calculateTotalRate() {
        return String.format("%d / %d * 100", getTotalPrize(), getTotalPrice());
    }

    private Integer getTotalPrize() {
        return result.entrySet().stream()
                .map(entry -> entry.getKey().getPrize() * entry.getValue())
                .reduce(0, Integer::sum);
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
