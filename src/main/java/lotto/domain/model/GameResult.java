package lotto.domain.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.service.Money;

public class GameResult {
    private EnumMap<PrizeOption, Integer> resultCounts;
    private double totalProfit = 0.0;

    public GameResult(final List<PrizeOption> givenLottosResults){
        this.resultCounts = new EnumMap<>(PrizeOption.class);
        for (PrizeOption result : givenLottosResults) {
            if(!result.equals(PrizeOption.UNDER_THREE)) this.resultCounts.put(result, this.resultCounts.getOrDefault(result,0) + 1);
        }
    }
    public void countProfitable(Money money) {
        int totalPrize = 0;
        for (Map.Entry<PrizeOption, Integer> entry : resultCounts.entrySet()) {
            totalPrize += entry.getKey().getPrizeAmount() * entry.getValue();
        }
        this.totalProfit = money.countPrize(totalPrize);
    }

    public EnumMap<PrizeOption, Integer> getResultCounts() {
        return resultCounts;
    }

    public double getTotalProfit() {
        return totalProfit;
    }
}
