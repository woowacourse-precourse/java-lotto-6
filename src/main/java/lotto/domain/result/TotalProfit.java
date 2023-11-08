package lotto.domain.result;

import java.util.Map;
import lotto.domain.Money;

public class TotalProfit {

    private double totalProfit;
    private final static double ROUNDING_PRECISION = 100.0;

    public TotalProfit(Map<LottoPrize, Integer> status, Money money) {
        createTotalProfit(status, money);
    }

    public void createTotalProfit(Map<LottoPrize, Integer> status, Money money){
        var totalPrize = status.entrySet().stream()
            .mapToInt(entry -> entry.getKey().getPrizeAmount() * entry.getValue())
            .sum();

        var result = (double) totalPrize/money.getMoney();
        this.totalProfit = result*ROUNDING_PRECISION;
    }

    public double getTotalProfit() {
        return totalProfit;
    }
}
