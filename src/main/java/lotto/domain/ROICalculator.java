package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class ROICalculator {

    public double calculate(long totalPrize, long investment) {
        BigDecimal bdTotalPrize = BigDecimal.valueOf(totalPrize);
        BigDecimal bdInvestment = BigDecimal.valueOf(investment);
        BigDecimal rawROI = bdTotalPrize.divide(bdInvestment, 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));
        rawROI = rawROI.setScale(1, RoundingMode.HALF_UP);
        return rawROI.doubleValue();
    }
}
