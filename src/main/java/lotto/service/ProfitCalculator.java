package lotto.service;

import lotto.domain.Result;
import lotto.domain.User;
import lotto.domain.Rank;

public class ProfitCalculator {

    public static double calcProfitRate(User user, Result result) {
        int totalProfit = calcTotalProfit(result);
        double profitRate = totalProfit / (double)(user.getAmount() * 1000) ;

        return (double) profitRate*100;

    }
    private static int calcTotalProfit(Result result) {
        int totalProfit = 0;
        for (Rank rank: result.getResults()) {
            totalProfit += rank.getAwardMoney();
        }
        return totalProfit;
    }
}
