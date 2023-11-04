package lotto.domain;

import java.util.List;

public class ProfitCalculator {

    List<Integer> winningLottoCounts;

    public ProfitCalculator(List<Integer> winningLottoCounts) {
        this.winningLottoCounts = winningLottoCounts;
    }

    public double calculateProfit(int money) {
        int sum = 0;
        sum += winningLottoCounts.get(Constants.FIRST_RANK) * Rank.FIRST.getPrize();
        sum += winningLottoCounts.get(Constants.SECOND_RANK) * Rank.SECOND.getPrize();
        sum += winningLottoCounts.get(Constants.THIRD_RANK) * Rank.THIRD.getPrize();
        sum += winningLottoCounts.get(Constants.FOURTH_RANK) * Rank.FOURTH.getPrize();
        sum += winningLottoCounts.get(Constants.FIFTH_RANK) * Rank.FIFTH.getPrize();
        return (double) sum / money * Constants.PERCENTAGE;
    }
}
