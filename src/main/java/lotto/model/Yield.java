package lotto.model;

import static lotto.util.Constant.*;

import java.util.HashMap;

public class Yield {

    public static Yield createYield() {
        return new Yield();
    }

    public String calculateYield(int purchaseAmount, HashMap<LottoRankings, Integer> lottoResult) {
        long totalPrizeMoney = 0;
        for (LottoRankings rank : lottoResult.keySet()) {
            totalPrizeMoney += (long) rank.getWinningAmount() * lottoResult.get(rank);
        }

        double result = (totalPrizeMoney * CONVERT_PERCENT) / (double) purchaseAmount;

        return String.format(DECIMAL_PLACES, result);
    }
}
