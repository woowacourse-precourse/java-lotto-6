package lotto;

import java.math.BigDecimal;
import java.util.Map;

public class Profit {
    private final static Double INITIALIZATION_AMOUNT = 0.0;
    private final static Double HUNDRED_PERCENT = 100.0;
    private final static Double ROUND_UP = 10.0;
    private Double profit;
    private Double totalAmount;

    public Profit(WinResult winResult, BuyAmount buyAmount) {
        totalAmount = INITIALIZATION_AMOUNT;
        for(Map.Entry<Rankings, Integer> entry : winResult.getWinResult().entrySet()) {
            totalAmount += (entry.getKey().getAmount()) * entry.getValue();
        }

        this.profit = (totalAmount / (buyAmount.getBuyAmount())) * HUNDRED_PERCENT;

    }

    public Double getProfit() {
        return this.profit;
    }
}
