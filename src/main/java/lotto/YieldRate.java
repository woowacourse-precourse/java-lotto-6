package lotto;

import static lotto.Constants.MessageConstant.TOTAL_YIELD_RATE;

public class YieldRate {

    private static final int THOUSAND = 1000;
    private static final double TEN_DOUBLE = 10.0;
    private final Double yieldRate;

    public static YieldRate newInstance(AmountToBuyLotto amountToBuyLotto, long totalAmount) {
        return new YieldRate(amountToBuyLotto, totalAmount);
    }

    private YieldRate(AmountToBuyLotto amountToBuyLotto, long totalAmount) {
        double amountToBuy = (double) amountToBuyLotto.getAmount();
        double total = (double) totalAmount;
        yieldRate = Math.round(total / amountToBuy * THOUSAND) / TEN_DOUBLE;
    }

    public String getRateMessage() {
        return
            TOTAL_YIELD_RATE.formatted(yieldRate);
    }
}
