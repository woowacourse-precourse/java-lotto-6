package lotto.model;

import java.util.HashMap;
import lotto.util.Constant;

public class Yield {

    public static Yield createYield() {
        return new Yield();
    }

    public String calculateYield(int purchaseAmount, HashMap<LottoRankings, Integer> lottoResult) {
        long totalPrizeMoney = 0;
        for (LottoRankings rank : lottoResult.keySet()) {
            totalPrizeMoney += (long) rank.getWinningAmount() * lottoResult.get(rank);
        }

        double result = (totalPrizeMoney * Constant.CONVERT_PERCENT) / (double) purchaseAmount;

        return String.format("%.1f", result);
    }
}
