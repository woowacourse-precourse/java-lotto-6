package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Results {
    private final Map<Ranking, Integer> results;
    private final int totalAmountSpent;

    public Results(List<Lotto> lottoTickets, Lotto winningLotto, int bonusNumber, int totalAmountSpent) {
        this.totalAmountSpent = totalAmountSpent;
        results = new HashMap<>();

        for (Lotto lotto : lottoTickets) {
            int matchCount = lotto.countMatch(winningLotto.getNumbers());
            boolean matchBonus = matchCount == 5 && lotto.getNumbers().contains(bonusNumber);
            Ranking ranking = Ranking.getRank(matchCount, matchBonus);
            results.put(ranking, results.getOrDefault(ranking, 0) + 1);
        }
    }

    public int getCount(Ranking ranking) {
        return results.getOrDefault(ranking, 0);
    }

    public long getTotalPrize() {
        return results.entrySet().stream()
                .mapToLong(e -> (long) e.getKey().getPrizeMoney() * e.getValue())
                .sum();
    }

    public double calculateEarningsRate() {
        long totalPrize = getTotalPrize();
        double earningsRate = (double) totalPrize / totalAmountSpent * 100;
        return Math.round(earningsRate * 100) / 100.0;
    }

    public int getTotalAmountSpent() {
        return totalAmountSpent;
    }
}
