package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class GameResult {
    private EnumMap<LottoResult, Integer> resultCounts;
    private double totalProfit = 0.0;

    public GameResult(List<LottoResult> results) {
        this.resultCounts = new EnumMap<>(LottoResult.class);
        for (LottoResult result : results) {
            if(!result.equals(LottoResult.NOTHING_MATCHES)) this.resultCounts.put(result, this.resultCounts.getOrDefault(result,0) + 1);
        }
    }

    public void countProfitable(int money) {
        int totalPrize = 0;
        for (Map.Entry<LottoResult, Integer> entry : resultCounts.entrySet()) {
            totalPrize += entry.getKey().getPrizeAmount() * entry.getValue();
        }
        this.totalProfit = (totalPrize) / (double) money * 100;
    }

    public EnumMap<LottoResult, Integer> getResultCounts() {
        return resultCounts;
    }

    public double getTotalProfit() {
        return totalProfit;
    }
}
