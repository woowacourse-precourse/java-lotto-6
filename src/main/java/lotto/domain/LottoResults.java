package lotto.domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.math.RoundingMode.HALF_UP;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.flatMapping;
import static java.util.stream.Collectors.groupingBy;

public class LottoResults {

    private static final int SCALE = 1;

    private final List<Rank> ranks;

    public LottoResults(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public double calculateTotalProfitRate(int inputPrice) {
        return BigDecimal.valueOf(calculatePercent(calculateTotalWinningMoney(), inputPrice))
                .setScale(SCALE, HALF_UP)
                .doubleValue();
    }

    public long calculateTotalWinningMoney() {
        return ranks.stream()
                .mapToLong(Rank::getWinningMoney)
                .sum();
    }

    private double calculatePercent(long totalWinningMoney, double inputPrice) {
        return (totalWinningMoney / inputPrice) * 100;
    }

    public Map<Rank, Long> generateRankGroup() {
        return Arrays.stream(Rank.values())
                .collect(
                        groupingBy(
                                rank -> rank,
                                flatMapping(rank ->
                                                this.ranks.stream()
                                                        .filter(result -> result.equals(rank)),
                                        counting()
                                )
                        )
                );
    }

}
