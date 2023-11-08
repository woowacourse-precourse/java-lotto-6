package lotto.util;

import java.util.Map;
import lotto.WinnerRating;

public class RateOfReturnCalculator {

    public static Double calculateRateOfReturn(Map<WinnerRating, Integer> winners, int lottoPurchaseAmount) {
        double totalReward = 0;
        for (WinnerRating winnerRating : winners.keySet()) {
            long reward = winnerRating.getReward();
            int cnt = winners.get(winnerRating);

            totalReward += reward * cnt;
        }

        int totalLottoPurchaseAmount = lottoPurchaseAmount * 1000;

        return totalReward / totalLottoPurchaseAmount * 100;
    }
}
