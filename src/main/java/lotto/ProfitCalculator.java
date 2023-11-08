package lotto;

import java.util.Map;
import java.util.Map.Entry;

public class ProfitCalculator {

    public static double calculateProfitRate(int purchaseAmount, int totalPrize) {
        double profit =  (totalPrize / (double) purchaseAmount) * 100.0;
        double roundProfit = Math.round(profit * 100) / 100.0;

        return roundProfit;
    }

    public static int calculateTotalPrize(Map<LottoRank, Integer> winningResult) {
        int totalPrize = 0;

        for (Entry<LottoRank, Integer> resultEntry : winningResult.entrySet()) {
            LottoRank lottoRank = resultEntry.getKey();
            int winningNumber = resultEntry.getValue();

            totalPrize += (lottoRank.getPrizeMoney() * winningNumber);
        }

        return totalPrize;
    }
}
