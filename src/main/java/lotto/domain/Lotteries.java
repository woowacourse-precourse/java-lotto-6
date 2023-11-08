package lotto.domain;

import java.math.BigDecimal;
import java.util.List;
import lotto.Lotto;

public class Lotteries {

    private final List<Lotto> lotteries;

    private Lotteries(final List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }

    public static Lotteries from(final List<Lotto> lotteries) {
        return new Lotteries(lotteries);
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }

    public BigDecimal calculateTotalWinningPrice(final Lotto other, final int bonusNumber) {
        int sum = lotteries.stream()
                .map(lotto -> lotto.calculateRank(other, bonusNumber))
                .mapToInt(Rank::getPrice)
                .sum();
        return BigDecimal.valueOf(sum);
    }
}
