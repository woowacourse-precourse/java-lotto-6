package lotto.service;

import lotto.domain.Result;
import lotto.domain.User;
import lotto.domain.Rank;


public class ProfitCalculator {
    public static long calcProfitRate(User user, Result result) {
        int totalProfit = calcTotalProfit(result);
        long profitRate = totalProfit / (user.getAmount() * 1000) *100;
        return profitRate;
    }
    private static Integer calcTotalProfit(Result result) {
        int totalProfit = 0;
        for (Rank rank: result.getResults()) {
            totalProfit += rank.getAwardMoney();
        }
        return totalProfit;
    }

}
