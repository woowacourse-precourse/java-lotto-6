package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class PrizeResult {
    private Map<Prize, Integer> result = new HashMap<>();

    public PrizeResult() {
        for (Prize prize : Prize.values()) {
            result.put(prize, 0);
        }
    }

    public void addPrize(Prize prize) {
        result.put(prize, result.get(prize) + 1);
    }

    public Map<Prize, Integer> getResult() {
        return result;
    }

    public double calculateProfitRate(int purchaseAmount) {
        double totalPrizeAmount = 0;
        for (Prize prize : Prize.values()) {
            totalPrizeAmount += prize.getPrizeAmount() * result.get(prize);
        }
        return (totalPrizeAmount / purchaseAmount) * 100;
    }
}
