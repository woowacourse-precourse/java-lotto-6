package lotto.domain.profit;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lotto.domain.LottoPurchaseAmount;
import lotto.domain.result.TotalPrizeAmount;

public class LottoProfitRateCalculator {

    public static final int PROFIT_RATE_SCALE = 3;

    public LottoProfitRate calculate(LottoPurchaseAmount purchaseAmount, TotalPrizeAmount totalPrizeAmount) {
        return new LottoProfitRate(applyProfitRateFormula(totalPrizeAmount, purchaseAmount));
    }

    private BigDecimal applyProfitRateFormula(TotalPrizeAmount totalPrizeAmount, LottoPurchaseAmount purchaseAmount) {
        return totalPrizeAmount.getAmount()
                .divide(purchaseAmount.getAmount(), PROFIT_RATE_SCALE, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100L));
    }

}
