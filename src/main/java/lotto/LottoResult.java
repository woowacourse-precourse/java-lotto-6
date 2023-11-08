package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public record LottoResult(BigDecimal rateOfReturn, Map<LottoRank, Integer> rankToCount) {

    public LottoResult(int purchaseMoney,
                       int earnMoney,
                       Map<LottoRank, Integer> rankToCount) {
        this(calculateRateOfReturn(purchaseMoney, earnMoney), rankToCount);
    }

    public String rateOfReturnString() {
        return rateOfReturn.toString();
    }

    private static BigDecimal calculateRateOfReturn(int purchaseMoney, int earnMoney) {
        return BigDecimal.valueOf(earnMoney)
                .divide(BigDecimal.valueOf(purchaseMoney), 3, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100))
                .setScale(1, RoundingMode.HALF_UP);
    }
}
