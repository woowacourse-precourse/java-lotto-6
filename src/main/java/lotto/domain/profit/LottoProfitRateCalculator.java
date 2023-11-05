package lotto.domain.profit;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lotto.domain.result.LottoGameResult;
import lotto.domain.LottoPurchaseAmount;
import lotto.domain.result.TotalPrizeAmount;

public class LottoProfitRateCalculator {

    public LottoProfitRate calculate(LottoPurchaseAmount purchaseAmount, LottoGameResult gameResult) {
        return new LottoProfitRate(applyProfitRateFormula(gameResult.calculateTotalPrizeAmount(), purchaseAmount));
    }

    private BigDecimal applyProfitRateFormula(TotalPrizeAmount totalPrizeAmount, LottoPurchaseAmount purchaseAmount) {
        return totalPrizeAmount.getAmount()
                .divide(purchaseAmount.getAmount(), RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100L));
    }

}
