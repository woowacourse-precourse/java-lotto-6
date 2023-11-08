package lotto.domain;

import lotto.enums.Ranking;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class LottoResult {
    private final Map<Ranking, Integer> rankingCounts;

    public LottoResult(Map<Ranking, Integer> rankingCounts, int lottosSize) {
        validateKeys(rankingCounts);
        validateValues(rankingCounts);
        validateValuesSum(rankingCounts, lottosSize);
        this.rankingCounts = rankingCounts;
    }

    public Map<Ranking, Integer> getRankingCounts() {
        return Map.copyOf(rankingCounts);
    }

    public BigDecimal calculatePrizeRate(Money money, int scale, RoundingMode roundingMode) {
        BigDecimal totalPrize = calculateTotalPrize();
        BigDecimal spent = BigDecimal.valueOf(money.getAmount());
        BigDecimal prizeRate = totalPrize.divide(spent, 10, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100))
                .setScale(scale, roundingMode);
        return prizeRate;
    }

    private void validateKeys(Map<Ranking, Integer> rankingCounts) {
        if (rankingCounts.keySet().size() != Ranking.values().length) {
            throw new IllegalStateException();
        }
    }

    private void validateValues(Map<Ranking, Integer> rankingCounts) {
        if (rankingCounts.values().stream().anyMatch(value -> value < 0)) {
            throw new IllegalStateException();
        }
    }

    private void validateValuesSum(Map<Ranking, Integer> rankingCounts, int lottoSize) {
        if (rankingCounts.values().stream().mapToInt(value -> value).sum() > lottoSize) {
            throw new IllegalStateException();
        }
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
}
