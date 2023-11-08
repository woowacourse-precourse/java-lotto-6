package lotto.domain;

import static java.util.Arrays.stream;

import java.util.List;
import lotto.constant.Rank;

public class ProfitRateCalculator {
    public ProfitRateCalculator() {
    }

    public double calculateProfitRate(List<Rank> ranks, Money money) {
        int totalGain = ranks.stream()
                .map(Rank::getPrize)
                .reduce(0, Integer::sum);

        return  (double) totalGain / money.getMoney() * 100;
    }
}
