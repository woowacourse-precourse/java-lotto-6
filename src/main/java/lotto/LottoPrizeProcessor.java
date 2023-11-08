package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoPrizeProcessor {

    public LottoResult calculatePrize(List<LottoRank> ranks, int purchaseMoney) {
        int earnMoney = 0;
        Map<LottoRank, Integer> rankToCount = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : ranks) {
            Integer currentCount = rankToCount.getOrDefault(rank, 0);
            rankToCount.put(rank, currentCount + 1);
            earnMoney += rank.getWinningMoney();
        }
        return new LottoResult(calculateRateOfReturn(purchaseMoney, earnMoney), rankToCount);
    }

    private BigDecimal calculateRateOfReturn(int purchaseMoney, int earnMoney) {
        return BigDecimal.valueOf(earnMoney)
                .divide(BigDecimal.valueOf(purchaseMoney), 3, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100));
    }
}
