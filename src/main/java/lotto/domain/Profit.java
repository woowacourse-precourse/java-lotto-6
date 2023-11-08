package lotto.domain;

import static lotto.domain.constants.DomainConstants.PERCENTAGE;

public class Profit {

    private final WinningLottoCounts winningLottoCounts;
    private final Money money;

    public Profit(WinningLottoCounts winningLottoCounts, Money money) {
        this.winningLottoCounts = winningLottoCounts;
        this.money = money;
    }

    public double calculate() {
        double sum = 0;
        for (Rank rank : Rank.values()) {
            sum += winningLottoCounts.getPrize(rank);
        }
        return sum / money.getMoney() * PERCENTAGE;
    }
}