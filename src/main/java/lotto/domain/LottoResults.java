package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import lotto.enums.Rank;

public class LottoResults {

    private final Map<Rank, Integer> results = new HashMap<>();

    public LottoResults() {
        for (Rank rank : Rank.values()) {
            results.put(rank, 0);
        }
    }

    public void addResult(int matchCount, boolean hasBonusNumber) {
        Rank rank = Rank.calculateRank(matchCount, hasBonusNumber);
        results.put(rank, results.get(rank) + 1);
    }

    public double calculateProfitRate(int amount) {
        return Math.round((float) calculateTotalPrize() / amount * 1000) / 10.0;
    }

    private int calculateTotalPrize() {
        int totalPrize = 0;
        for (Rank rank : results.keySet()) {
            totalPrize += rank.getWinningMoney() * results.get(rank);
        }
        return totalPrize;
    }

    public Map<Rank, Integer> getResults() {
        return Collections.unmodifiableMap(results);
    }
}
