package lotto.model;

import java.util.EnumMap;
import java.util.List;

public class WinStatistics {
    private static final Integer LOTTO_PRICE = 1000;
    private static final double PERCENTAGE_UNIT = 100.0;

    private final EnumMap<Ranking, Integer> statistics;

    private WinStatistics(EnumMap<Ranking, Integer> statistics) {
        this.statistics = statistics;
    }

    public static WinStatistics from(List<Ranking> rankings) {
        return new WinStatistics(createStatistics(rankings));
    }

    private static EnumMap<Ranking, Integer> createStatistics(List<Ranking> rankings) {
        return rankings.stream()
                .collect(
                        () -> new EnumMap<>(Ranking.class),
                        (map, ranking) -> map.put(ranking, map.getOrDefault(ranking, 0) + 1),
                        EnumMap::putAll
                );
    }

    public double calculateProfit() {
        return (calculateTotalReward() * PERCENTAGE_UNIT) / calculateTotalPurchaseAmount();
    }

    private long calculateTotalReward() {
        return statistics.entrySet().stream()
                .mapToLong(result -> calculateReward(result.getKey(), result.getValue()))
                .sum();
    }

    private long calculateReward(Ranking rank, int count) {
        return rank.getReward() * count;
    }

    private double calculateTotalPurchaseAmount() {
        long totalLottoCount = getTotalLottoCount();
        return totalLottoCount * LOTTO_PRICE;
    }

    private long getTotalLottoCount() {
        return statistics.values()
                .stream()
                .mapToLong(Long::valueOf)
                .sum();
    }

    public EnumMap<Ranking, Integer> getStatistics() {
        return statistics;
    }
}
