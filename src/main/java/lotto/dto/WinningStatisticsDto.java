package lotto.dto;

import java.util.Map;
import lotto.domain.WinningRank;

public record WinningStatisticsDto(Map<WinningRank, Integer> countOfRank, int lottoPrice) {

    private static final int RATE_TO_PERCENTAGE = 100;

    public double getRateOfReturnPercentage() {
        long sum = sumOfPrice();
        long totalCount = calculateTotalCount();

        return (double) sum / (totalCount * lottoPrice) * RATE_TO_PERCENTAGE;
    }

    private long sumOfPrice() {
        return countOfRank.keySet().stream()
                .mapToLong(rank -> sumOfPrice(rank, countOfRank.get(rank)))
                .sum();
    }

    private long sumOfPrice(WinningRank rank, int count) {
        return rank.getPrice() * count;
    }

    private long calculateTotalCount() {
        return countOfRank.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
