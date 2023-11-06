package lotto.domain.calculator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RateOfReturn {
    private static int totalPurchaseAmount;
    private static int totalProfitAmount;
    private static double rateOfReturn;
    private static Map<String, Integer> prizeMoney = new HashMap<>();

    public RateOfReturn(int totalPurchaseAmount, Map<String, Integer> prize) {
        putPrizeMoney();
        int sumPrize = 0;
        sumPrize += prize.get("first") * prizeMoney.get("first");
        sumPrize += prize.get("second") * prizeMoney.get("second");
        sumPrize += prize.get("third") * prizeMoney.get("third");
        sumPrize += prize.get("fourth") * prizeMoney.get("fourth");
        sumPrize += prize.get("fifth") * prizeMoney.get("fifth");
        this.rateOfReturn = ((double)sumPrize / totalPurchaseAmount) * 100;
    }

    private void putPrizeMoney() {
        prizeMoney.put("first", 2000000000);
        prizeMoney.put("second", 30000000);
        prizeMoney.put("third", 1500000);
        prizeMoney.put("fourth", 50000);
        prizeMoney.put("fifth", 5000);
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
