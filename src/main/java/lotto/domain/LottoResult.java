package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import lotto.data.LottoPrize;

public class LottoResult {
    private final Map<LottoPrize, BigDecimal> lottoRank;
    private final BigDecimal totalPrize;
    private final BigDecimal profitPercent;

    private final static int PROFIT_PERCENT_DIGITS_AFTER_DECIMAL_POINT = 5;
    private final static BigDecimal FOR_PERCENT = BigDecimal.valueOf(100);

    public LottoResult(Map<LottoPrize, BigDecimal> lottoRank, BigDecimal purchaseAmount) {
        this.lottoRank = lottoRank;
        this.totalPrize = calculateTotalPrize(lottoRank);
        this.profitPercent = calculateProfitPercent(totalPrize, purchaseAmount);
    }

    public HashMap<LottoPrize, BigDecimal> getLottoRank() {
        return new HashMap<>(lottoRank);
    }

    public BigDecimal getProfitPercent() {
        return profitPercent;
    }

    private static BigDecimal calculateTotalPrize(Map<LottoPrize, BigDecimal> lottoRank) {
        BigDecimal totalPrize = BigDecimal.ZERO;
        for (LottoPrize lottoResult : lottoRank.keySet()) {
            BigDecimal count = lottoRank.get(lottoResult);
            BigDecimal prize = lottoResult.getPrize();
            totalPrize = totalPrize.add(prize.multiply(count));
        }
        return totalPrize;
    }

    private static BigDecimal calculateProfitPercent(BigDecimal totalPrize, BigDecimal purchaseAmount) {
        return totalPrize.multiply(FOR_PERCENT)
                .divide(purchaseAmount, PROFIT_PERCENT_DIGITS_AFTER_DECIMAL_POINT, RoundingMode.DOWN);
    }

}
