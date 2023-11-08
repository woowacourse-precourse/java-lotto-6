package lotto.service;

import java.util.List;
import lotto.model.Constants;
import lotto.model.LottoPrize;

public class LottoProfitCalculator {

    public static double calculateLottoProfit(int purchaseAmount, List<Integer> lottoResult) {
        double prizeMoneySum = Constants.INITIAL_MONEY_SUM;

        for (int i = LottoPrize.FIRST.getPrizeRank(); i <= LottoPrize.FIFTH.getPrizeRank() ; i++) {
            prizeMoneySum += (lottoResult.get(i) * Constants.PRIZE_MONEY[i]);
        }

        return Math.round(prizeMoneySum / purchaseAmount * Constants.PERCENTAGE_FACTOR * Constants.ROUNDING_FACTOR)
            / Constants.DECIMAL_PLACE;
    }

}
