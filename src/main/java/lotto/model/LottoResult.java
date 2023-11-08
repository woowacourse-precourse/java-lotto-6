package lotto.model;

import static lotto.util.Constants.LOTTO_PRICE;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> resultCount;
    private final WinningNumbers winningNumbers;

    public LottoResult(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
        resultCount = initializeResultCount();
    }

    private Map<Rank, Integer> initializeResultCount() {
        Map<Rank, Integer> count = new HashMap<>();
        for (Rank rank : Rank.values()) {
            count.put(rank, 0);
        }
        return count;
    }

    public void addResult(int matchCount, boolean hasBonusNumber) {
        Rank rank = Rank.valueOf(matchCount, hasBonusNumber);
        resultCount.put(rank, resultCount.get(rank) + 1);
    }

    public int getCount(Rank rank) {
        return resultCount.get(rank);
    }

    public double calculateWinningRate(int purchaseAmount) {
        int totalPrize = Rank.calculateTotalPrize(resultCount);
        int profit = totalPrize - purchaseAmount;
        return calculateWinningRate(profit < 0 ? totalPrize : profit, purchaseAmount);
    }

    private double calculateWinningRate(int numerator, int denominator) {
        return Math.round(((double) numerator / denominator) * LOTTO_PRICE) / 10.0;
    }
}
