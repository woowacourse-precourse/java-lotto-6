package lotto.model;

import java.util.*;

public class WinStatistics {
    private static final double PERCENTAGE_UNIT = 100.0;

    private final EnumMap<Ranking, Integer> statistics;

    private WinStatistics(EnumMap<Ranking, Integer> statistics) {
        this.statistics = statistics;
    }

    public static WinStatistics from(List<Ranking> rankings) {
        EnumMap<Ranking, Integer> statistics = initStatistics();
        rankings.forEach(rank -> statistics.merge(rank, 1, Integer::sum));
        return new WinStatistics(statistics);
    }

    private static EnumMap<Ranking, Integer> initStatistics() {
        EnumMap<Ranking, Integer> statistics = new EnumMap<>(Ranking.class);
        Arrays.stream(Ranking.values())
                .forEach(rank -> statistics.put(rank, 0));
        return statistics;
    }

    public double calculateProfit() {
        long totalReward = calculateTotalReward();
        long totalPurchaseAmount = calculateTotalPurchaseAmount();
        return (double) totalReward / totalPurchaseAmount * PERCENTAGE_UNIT;
    }

    private long calculateTotalReward() {
        return statistics.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getReward() * entry.getValue())
                .sum();
    }

    private long calculateTotalPurchaseAmount() {
        return statistics.values().stream()
                .mapToLong(Integer::longValue)
                .sum() * LottoStore.LOTTO_PRICE;
    }

    public EnumMap<Ranking, Integer> getStatistics() {
        return statistics;
    }
}
