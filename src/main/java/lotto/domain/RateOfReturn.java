package lotto.domain;

import lotto.domain.enums.LottoPrize;

import java.util.List;
import java.util.Map;

public class RateOfReturn {
    private static final int NONE = 0;
    private final double rateOfReturn;

    public RateOfReturn(List<LottoPrize> allLottoPrizes) {
        this.rateOfReturn = calculateRateOfReturn(allLottoPrizes);;
    }

    public double calculateRateOfReturn(List<LottoPrize> allLottoPrizes) {
        Map<LottoPrize, Integer> lottoPrizeResults = LottoPrize.lottoPrizeCount(allLottoPrizes);
        Long income = 0L;
        int totalCount = 0;
        List<LottoPrize> ranks = List.of(LottoPrize.FIFTH, LottoPrize.FOURTH, LottoPrize.THIRD, LottoPrize.SECOND, LottoPrize.FIRST);

        for (LottoPrize rank : ranks) {
            Integer count = lottoPrizeResults.get(rank);
            totalCount += count;
            income += rank.prizeMoney * count;
        }
        return roundRateOfReturn(income, totalCount);
    }

    public double roundRateOfReturn(Long income, int count) {
        if (count != NONE) {
            return Math.round(income / count * 1000 * 10) / 10;
        }

        return NONE;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
