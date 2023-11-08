package lotto.util;

import lotto.constants.Price;
import lotto.dto.LottoResult;

public class ProfitRateCalculator {

    public static double execute(LottoResult result, int purchasePrice) {
        long profit = 0;

        profit += Long.valueOf(result.getRank1() * Price.RANK_1.getPrice());
        profit += Long.valueOf(result.getRank2() * Price.RANK_2.getPrice());
        profit += Long.valueOf(result.getRank3() * Price.RANK_3.getPrice());
        profit += Long.valueOf(result.getRank4() * Price.RANK_4.getPrice());
        profit += Long.valueOf(result.getRank5() * Price.RANK_5.getPrice());

        return ((double)profit / purchasePrice) * 100;
    }

}
