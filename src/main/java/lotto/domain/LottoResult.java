package lotto.domain;

import lotto.enums.Ranking;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class LottoResult {
    private final Map<Ranking, Integer> rankingCounts;

    public LottoResult(Map<Ranking, Integer> rankingCounts) {
        this.rankingCounts = rankingCounts;
    }

    public BigDecimal calculatePrizeRate(Money money, int scale, RoundingMode roundingMode) {
        BigDecimal totalPrize = calculateTotalPrize();
        BigDecimal spent = BigDecimal.valueOf(money.getAmount());
        BigDecimal prizeRate = totalPrize.divide(spent, 10, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100))
                .setScale(scale, roundingMode);
        return prizeRate;
    }

    private BigDecimal calculateTotalPrize() {
        BigDecimal totalPrize = BigDecimal.ZERO;

        for (Map.Entry<Ranking, Integer> entry : rankingCounts.entrySet()) {
            BigDecimal rankingPrize = BigDecimal.valueOf(entry.getKey().getPrize())
                    .multiply(BigDecimal.valueOf(entry.getValue()));

            totalPrize = totalPrize.add(rankingPrize);
        }

        return totalPrize;
    }

    public Map<Ranking, Integer> getRankingCounts() {
        return Map.copyOf(rankingCounts);
    }
}
