package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<Ranking, Integer> counter;
    private final BigDecimal roi;

    public LottoResult(List<Ranking> rankings, int investmentCost) {
        this.counter = new HashMap<>();
        rankings.forEach(ranking ->
                counter.put(ranking, counter.merge(ranking, 1, Integer::sum)));
        this.roi = calculateROI(investmentCost);
    }

    public int getCount(Ranking ranking) {
        return counter.getOrDefault(ranking, 0);
    }

    public BigDecimal getRoi() {
        return roi;
    }

    private BigDecimal calculateROI(final int investmentCost) {
        BigDecimal investmentGain = calculateInvestmentReturn();
        return investmentGain.multiply(BigDecimal.valueOf(100))
                .divide(BigDecimal.valueOf(investmentCost), 1, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateInvestmentReturn() {
        return counter.entrySet().stream()
                .map(entry -> BigDecimal.valueOf(entry.getKey().getPrizeMoney())
                        .multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
