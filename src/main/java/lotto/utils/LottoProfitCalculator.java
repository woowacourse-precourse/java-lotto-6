package lotto.utils;

import java.util.Map;
import lotto.model.LottoPrize;

public class LottoProfitCalculator {

    public static Double findLottoProfitPercentage(Map<LottoPrize, Long> winningCountPerLottoPrize,
                                                   Integer lotteriesCount) {
        Long earnMoney = lottoPrizeCount(winningCountPerLottoPrize);
        return (earnMoney / (double) (lotteriesCount * 1000)) * 100.0;
    }

    private static Long lottoPrizeCount(Map<LottoPrize, Long> winningCountPerLottoPrize) {
        Long sum = 0L;
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            Long lottoPrizeCount = winningCountPerLottoPrize.get(lottoPrize);
            sum += lottoPrize.getPrizeMoney().longValue() * lottoPrizeCount;
        }

        return sum;
    }
}