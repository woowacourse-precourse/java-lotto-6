package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.dto.LottoCompareResult;

public class Result {
    private final Map<Rank, Integer> result = new HashMap<>();
    private long profitAmount;
    private double profitRate;

    private void addResult(LottoCompareResult compareResult) {
        Rank rank = Rank.valueOf(compareResult.matchCount(), compareResult.matchBonus());
        result.put(rank, result.getOrDefault(rank, 0) + 1);
    }

    public int getCount(Rank rank) {
        return result.getOrDefault(rank, 0);
    }

    public void calculateTotalWinningMoney(List<LottoCompareResult> compareResultList) {
        for (LottoCompareResult compareResult : compareResultList) {
            addResult(compareResult);
        }
        long amount = result.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getWinningMoney() * entry.getValue())
                .sum();
        this.profitAmount = amount;
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }

    public int getCountOfMatch(Rank rank) {
        Integer count = result.get(rank);
        if (count == null) {
            return 0;
        }
        return count.intValue();
    }

    public void calculateProfitRate(long inputAmount) {
        double profitRate = (double) profitAmount / inputAmount * 100;
        double roundedProfitRate = Math.round(profitRate * 100) / 100.0;
        this.profitRate = roundedProfitRate;
    }

    public double getProfitRate() {
        return profitRate;
    }

    public long getProfitAmount() {
        return profitAmount;
    }
}
