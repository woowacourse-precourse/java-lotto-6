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
            BigDecimal prizePrice = BigDecimal.valueOf(rank.getPrize());

            lottoPrizePrice = lottoPrizePrice.add(prizePrice.multiply(count));
        }
        return lottoPrizePrice;
    }

    private static BigDecimal getPercentPrize(BigDecimal buyPrice, BigDecimal returnPrice) {
        // 나누기 할때 나누어 떨어지지 않을 경우 소숫점 몇자리까지 표현해야할 지정해야 하기 때문에 divide 에 argument 추가했다.

        // 나누기를 먼저 하고 곱하기를 하면, 소숫점 정확도가 달라지기 때문에 곱하기를 먼저 하고 나눈다.

        // ex) 수익금 : 5000원, 구매금액 100,000원
        // 1. 나누기를 먼저하면..
        // 5000 / 100,000 = 0.05 (여기서 반올림) -> 0.1 (값이 훼손됨)
        // 이후 백분위를 위한 100 곱하기 : 0.1 * 100 = 10%
        // 2. 곱하기를 먼저하면..
        // 5000 * 100(백분위) = 500,000
        // 500,000 / 100,000 = 5% (이게 정확한 값)
        return returnPrice.multiply(BigDecimal.valueOf(100))
                .divide(buyPrice, DECIMAL_SCALE_BASE, RoundingMode.HALF_UP);
    }
}
