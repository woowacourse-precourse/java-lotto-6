package lotto.domain;

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

    public List<Rank> calculateRanks(final Lotto other, final int bonusNumber) {
        return lotteries.stream()
                .map(lotto -> lotto.calculateRank(other, bonusNumber))
                .toList();
    }
}
