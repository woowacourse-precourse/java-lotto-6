package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;

public class ResultChecker {
    public HashMap<Rank, Integer> checkLottoResult(List<Lotto> lottos, WinningLotto winningLotto) {
        HashMap<Rank, Integer> results = intializeResults();
        for (Lotto lotto : lottos) {
            Rank rank = Rank.checkRank(lotto, winningLotto);
            updateResult(results, rank);
        }
        return results;
    }

    public HashMap<Rank, Integer> updateResult (HashMap<Rank, Integer> results, Rank rank) {
        if (rank != null) {
            results.put(rank, results.get(rank) + 1);
        }
        return results;
    }

    public BigDecimal calculateProfit(HashMap<Rank, Integer> result) {
        int totalInvestment = result.values().stream().mapToInt(Integer::intValue).sum() * 1000;
        BigDecimal totalInvestmentProcessed = new BigDecimal(String.valueOf(totalInvestment));
        int totalProfit = result.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrizeAmount()* entry.getValue())
                .sum();
        BigDecimal totalProfitProcessed = new BigDecimal(String.valueOf(totalProfit));
        BigDecimal oneHundred = new BigDecimal("100");
        BigDecimal earningRate = totalProfitProcessed.multiply(oneHundred).divide(totalInvestmentProcessed, 1, RoundingMode.HALF_UP);
        return earningRate;
    }


    private HashMap<Rank, Integer> intializeResults() {
        HashMap<Rank, Integer> results = new HashMap<>();
        for (Rank rank : Rank.values()) {
            results.put(rank, 0);
        }
        return results;
    }
}
