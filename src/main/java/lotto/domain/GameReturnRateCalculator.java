package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class GameReturnRateCalculator {
    private static final int DECIMAL_SCALE_BASE = 1;

    public static BigDecimal getReturnRate(Map<Rank, Integer> rankingCountResult, BigDecimal buyPrice) {
        BigDecimal totalReturn = getLottoTotalPrizePrice(rankingCountResult);
        return getPercentPrize(buyPrice, totalReturn);
    }

    private static BigDecimal getLottoTotalPrizePrice(Map<Rank, Integer> rankingCountResult) {
        BigDecimal lottoPrizePrice = BigDecimal.ZERO;

        for (Rank rank : rankingCountResult.keySet()) {
            if (rank == Rank.UNRANK) {
                continue;
            }

            BigDecimal count = BigDecimal.valueOf(rankingCountResult.get(rank));
            BigDecimal prizePrice = BigDecimal.valueOf(rank.getPrizePrice());

            lottoPrizePrice = lottoPrizePrice.add(prizePrice.multiply(count));
        }
        return lottoPrizePrice;
    }

    private static BigDecimal getPercentPrize(BigDecimal buyPrice, BigDecimal returnPrice) {

        return returnPrice.multiply(BigDecimal.valueOf(100))
                .divide(buyPrice, DECIMAL_SCALE_BASE, RoundingMode.HALF_UP);
    }
}