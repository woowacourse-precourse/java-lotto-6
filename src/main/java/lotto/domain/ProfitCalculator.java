package lotto.domain;

import java.util.List;

import static lotto.domain.Constants.*;

public class ProfitCalculator {

    private final List<Integer> winningLottoCounts;

    public ProfitCalculator(List<Integer> winningLottoCounts) {
        this.winningLottoCounts = winningLottoCounts;
    }

    public double calculateProfit(Money money) {
        double sum = 0;
        for (Rank rank : Rank.values()) {
            sum += winningLottoCounts.get(rank.getRankIndex()) * rank.getPrize();
        }
        return sum / money.getMoney() * PERCENTAGE;
    }
}
