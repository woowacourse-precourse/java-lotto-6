package lotto.lottoGame;

import lotto.lottoGame.rank.Rank;
import lotto.lottoGame.rank.RankCounter;

public class ResultCalculrator {
    public double calculateIncomeRate(long incomeValue, int purchaseValue) {
        return Math.round(((float) incomeValue / purchaseValue) * 1000) / 10.0;
    }

    public long incomeSum(RankCounter rankCounter) {
        long sum = 0;
        Rank[] rankValues = Rank.values();

        for (Rank rank : rankValues) {
            sum += (rankCounter.getRankCount(rank) * rank.getPrize());
        }

        return sum;
    }
}
