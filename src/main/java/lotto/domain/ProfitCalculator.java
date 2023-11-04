package lotto.domain;

import java.util.List;

public class ProfitCalculator {

    private final List<Integer> winningLottoCounts;

    public ProfitCalculator(List<Integer> winningLottoCounts) {
        this.winningLottoCounts = winningLottoCounts;
    }

    public double calculateProfit(int money) {
        int sum = 0;
        sum += winningLottoCounts.get(Rank.FIRST.getRankIndex()) * Rank.FIRST.getPrize();
        sum += winningLottoCounts.get(Rank.SECOND.getRankIndex()) * Rank.SECOND.getPrize();
        sum += winningLottoCounts.get(Rank.THIRD.getRankIndex()) * Rank.THIRD.getPrize();
        sum += winningLottoCounts.get(Rank.FOURTH.getRankIndex()) * Rank.FOURTH.getPrize();
        sum += winningLottoCounts.get(Rank.FIFTH.getRankIndex()) * Rank.FIFTH.getPrize();
        return (double) sum / money * Constants.PERCENTAGE;
    }
}
