package lotto.dto;

import java.util.Map;
import lotto.domain.WinningRanking;

public record WinningStatisticsDto(Map<WinningRanking, Integer> countOfRanking, int price) {

    private static final int NOT_EXIST = 0;
    private static final int RATE_TO_PERCENTAGE = 100;

    public double getRateOfReturnPercentage() {
        long sum = sumOfPrice();
        long totalCount = calculateTotalCount();

        return (double) sum / (totalCount * price) * RATE_TO_PERCENTAGE;
    }

    private long sumOfPrice() {
        return countOfRanking.keySet().stream()
                .mapToLong(rank -> sumOfPrice(rank, countOfRanking.getOrDefault(rank,NOT_EXIST)))
                .sum();
    }

    private long sumOfPrice(WinningRanking ranking, int count) {
        return ranking.getPrice() * count;
    }

    private long calculateTotalCount() {
        return countOfRanking.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
