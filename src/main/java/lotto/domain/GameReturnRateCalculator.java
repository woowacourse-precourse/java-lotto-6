package lotto.domain;

import java.util.Map;

public class GameReturnRateCalculator {

    public static double getReturnRate(Map<Rank, Integer> rankIntegerMap, int inPrice) {
        int totalReturn = getLottoTotalPrizePrice(rankIntegerMap);
        return getPercentPrize(inPrice, totalReturn);
    }

    /**
     * 수익률 계산 기능
     */
    private static int getLottoTotalPrizePrice(Map<Rank, Integer> rankIntegerMap) {
        int lottoPrizePrice = 0;

        for (Rank rank : rankIntegerMap.keySet()) {
            if (rank == Rank.UNRANK) {
                continue;
            }

            lottoPrizePrice += rank.getPrize() * rankIntegerMap.get(rank);
        }
        return lottoPrizePrice;
    }

    private static double getPercentPrize(int inPrice, int outPrice) {
        double inVal = inPrice + 0.0;
        double outVal = outPrice + 0.0;

        double result = outVal / inVal * 100;
        result = Math.round(result * 100) / 100.0; //소수점 둘째 자리에서 반올림하고,
        return result;
    }
}
