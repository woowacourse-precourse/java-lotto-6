package lotto.domain;

import java.math.BigDecimal;
import java.util.List;

import static java.math.RoundingMode.HALF_UP;

public class LottoResults {

    private static final int SCALE = 1;

    private final List<Rank> ranks;

    public LottoResults(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public long calculateTotalWinningMoney() {
        return ranks.stream()
                .mapToLong(Rank::getWinningMoney)
                .sum();
    }

    public double calculateTotalProfit(long totalWinningMoney, int inputPrice) {
        return BigDecimal.valueOf(calculatePercent(totalWinningMoney, inputPrice))
                .setScale(SCALE, HALF_UP)
                .doubleValue();
    }

    private double calculatePercent(long totalWinningMoney, double inputPrice) {
        return (totalWinningMoney / inputPrice) * 100;
    }

}
