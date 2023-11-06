package lotto.domain;

import static java.util.Arrays.stream;

import java.util.List;
import lotto.Rank;

public class ProfitRateCalculator {
    public ProfitRateCalculator() {
    }

    public long calculateProfitRate(List<Rank> ranks, Money money) {
        int totalGain = ranks.stream()
                .map(Rank::getPrize)
                .reduce(0, Integer::sum);

        return totalGain / money.getMoney();
    }
}
