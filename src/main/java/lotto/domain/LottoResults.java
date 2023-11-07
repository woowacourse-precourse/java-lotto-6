package lotto.domain;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static java.math.RoundingMode.HALF_UP;

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

    private long calculateTotalWinningMoney() {
        return ranks.stream()
                .mapToLong(Rank::getWinningMoney)
                .sum();
    }

    private double calculatePercent(long totalWinningMoney, double inputPrice) {
        return (totalWinningMoney / inputPrice) * 100;
    }

    public List<Rank> getRanks() {
        return Collections.unmodifiableList(ranks);
    }

}
