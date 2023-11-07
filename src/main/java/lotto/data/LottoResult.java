package lotto.data;

import java.math.BigDecimal;
import java.util.HashMap;
import lotto.message.LottoPrize;

public class LottoResult {
    private final HashMap<LottoPrize, BigDecimal> lottoRank;
    private final BigDecimal totalPrize;
    private final float profitPercent;

    public LottoResult(HashMap<LottoPrize, BigDecimal> lottoRank, BigDecimal purchaseAmount) {
        this.lottoRank = lottoRank;
        this.totalPrize = calculateTotalPrize(lottoRank);
        this.profitPercent = calculateProfitPercent(totalPrize, purchaseAmount);
    }

    public HashMap<LottoPrize, BigDecimal> getLottoRank() {
        return new HashMap<>(lottoRank);
    }

    public float getProfitPercent() {
        return profitPercent;
    }

    private static BigDecimal calculateTotalPrize(HashMap<LottoPrize, BigDecimal> lottoRank) {
        BigDecimal totalPrize = BigDecimal.ZERO;
        for (LottoPrize lottoResult : lottoRank.keySet()) {
            BigDecimal count = lottoRank.get(lottoResult);
            BigDecimal prize = BigDecimal.valueOf(lottoResult.getPrize());
            totalPrize = totalPrize.add(prize.multiply(count));
        }
        return totalPrize;
    }

    private static float calculateProfitPercent(BigDecimal totalPrize, BigDecimal purchaseAmount) {
        return totalPrize.divide(purchaseAmount).floatValue() * 100;
    }

}
