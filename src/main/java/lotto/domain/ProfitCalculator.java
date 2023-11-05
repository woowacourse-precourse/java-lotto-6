package lotto.domain;

import static lotto.domain.Constants.*;

public class ProfitCalculator {

    private final WinningLottoCounts winningLottoCounts;

    public ProfitCalculator(WinningLottoCounts winningLottoCounts) {
        this.winningLottoCounts = winningLottoCounts;
    }

    public double calculateProfit(Money money) {
        double sum = 0;
        for (Rank rank : Rank.values()) {
            sum += winningLottoCounts.getPrize(rank);
        }
        return sum / money.getMoney() * PERCENTAGE;
    }
}
