package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class GameReturnRateCalculator {
    private static final int DECIMAL_SCALE_BASE = 1;

    public static BigDecimal getReturnRate(Map<Rank, Integer> rankIntegerMap, BigDecimal buyPrice) {
        BigDecimal totalReturn = getLottoTotalPrizePrice(rankIntegerMap);
        return getPercentPrize(buyPrice, totalReturn);
    }

    /**
     * 수익률 계산 기능
     */
    private static BigDecimal getLottoTotalPrizePrice(Map<Rank, Integer> rankIntegerMap) {
        BigDecimal lottoPrizePrice = BigDecimal.ZERO;

        for (Rank rank : rankIntegerMap.keySet()) {
            if (rank == Rank.UNRANK) {
                continue;
            }

            BigDecimal count = BigDecimal.valueOf(rankIntegerMap.get(rank));
            BigDecimal prizePrice = BigDecimal.valueOf(rank.getPrize());

            lottoPrizePrice = lottoPrizePrice.add(prizePrice.multiply(count));
        }
        return lottoPrizePrice;
    }

    private static BigDecimal getPercentPrize(BigDecimal buyPrice, BigDecimal returnPrice) {
        return returnPrice.divide(buyPrice)
                .multiply(BigDecimal.valueOf(100))
                .setScale(DECIMAL_SCALE_BASE, RoundingMode.HALF_UP);
    }
}
