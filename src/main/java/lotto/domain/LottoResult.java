package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> winnings = new HashMap<>();
    private long totalPrize = 0;
    private double profitRate = 0;

    public LottoResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        calculateWinnings(lottos, winningNumbers, bonusNumber);
        calculateTotalPrize();
        calculateProfitRate(lottos.size());
    }

    private void calculateWinnings(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottos) {
            Rank rank = determineRank(lotto, winningNumbers, bonusNumber);
            incrementWinningCount(rank);
        }
    }

    private Rank determineRank(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = lotto.countMatches(winningNumbers);
        boolean matchBonus = lotto.contains(bonusNumber);
        return Rank.valueOf(matchCount, matchBonus);
    }

    private void incrementWinningCount(Rank rank) {
        winnings.put(rank, winnings.getOrDefault(rank, 0) + 1);
    }

    private void calculateTotalPrize() {
        for (Rank rank : winnings.keySet()) {
            totalPrize += calculatePrizeForRank(rank);
        }
    }

    private long calculatePrizeForRank(Rank rank) {
        return (long) winnings.get(rank) * rank.getPrize();
    }

    private void calculateProfitRate(int numberOfLottos) {
        if (totalPrize <= 0) {
            profitRate = 0;
        }
        profitRate = (double) totalPrize / (numberOfLottos * Lotto.PRICE);
    }

    public Map<Rank, Integer> getWinnings() {
        return new HashMap<>(winnings);
    }

    public long getTotalPrize() {
        return totalPrize;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
