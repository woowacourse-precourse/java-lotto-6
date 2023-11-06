package lotto.domain;

import lotto.domain.enums.LottoPrize;

import java.util.List;
import java.util.Map;

public class RateOfReturn {
    private static final int NONE = 0;
    private static final int LOTTO_PRICE = 1000;
    private static final int PERCENT = 100;
    private final double rateOfReturn;

    public RateOfReturn(List<LottoPrize> allLottoPrizes, LottoCount lottoCount) {
        this.rateOfReturn = calculateRateOfReturn(allLottoPrizes, lottoCount);
    }

    public double calculateRateOfReturn(List<LottoPrize> allLottoPrizes, LottoCount lottoCount) {
        Map<LottoPrize, Integer> lottoPrizeResults = LottoPrize.lottoPrizeCount(allLottoPrizes);
        Long income = 0L;
        int totalCount = 0;
        List<LottoPrize> ranks = List.of(LottoPrize.FIFTH, LottoPrize.FOURTH, LottoPrize.THIRD, LottoPrize.SECOND, LottoPrize.FIRST);

        for (LottoPrize rank : ranks) {
            Integer count = lottoPrizeResults.get(rank);
            totalCount += count;
            income += rank.prizeMoney * count;
        }
        System.out.println(income + " " + lottoCount.getLottoCount());
        return roundRateOfReturn(income, lottoCount);
    }

    public double roundRateOfReturn(Long income, LottoCount lottoCount) {
        int count = lottoCount.getLottoCount();
        if (count != NONE) {
            return Math.round(income*PERCENT*10 / (count * LOTTO_PRICE) )/10.0;
        }
        return NONE;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
