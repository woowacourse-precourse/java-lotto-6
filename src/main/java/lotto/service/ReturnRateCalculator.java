package lotto.service;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ReturnRateCalculator {

    private final List<Map.Entry<Integer, Boolean>> results;

    private final int purchaseAmount;

    private int sumPrizeMoney = 0;

    public ReturnRateCalculator(List<Map.Entry<Integer, Boolean>> results, int purchaseAmount) {
        this.results = results;
        this.purchaseAmount = purchaseAmount;
    }

    public double calculateReturnRate() {
        for (Map.Entry<Integer, Boolean> result : results) {
            getSumPrizeMoney(result);
        }
        if(sumPrizeMoney == 0) {
            return 0;
        }
        return ((double) sumPrizeMoney / purchaseAmount) * 100;
    }

    private void getSumPrizeMoney(Entry<Integer, Boolean> result) {
        if (result.getKey() == 6) {
            sumPrizeMoney += 2000000000;
        }
        if (result.getKey() == 5 && result.getValue() == true) {
            sumPrizeMoney += 30000000;
        }
        if (result.getKey() == 5 && result.getValue() == false) {
            sumPrizeMoney += 1500000;
        }
        if (result.getKey() == 4) {
            sumPrizeMoney += 50000;
        }
        if (result.getKey() == 3) {
            sumPrizeMoney += 5000;
        }
    }
}
