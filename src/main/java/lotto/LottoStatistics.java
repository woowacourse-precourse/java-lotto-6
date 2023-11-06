package lotto;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class LottoStatistics {
    private Map<Rank, Integer> results;
    private float profit;

    LottoStatistics(List<Lotto> tickets, Lotto userLotto, int bonusNumber) {
        results = new HashMap<>();
        setResults(tickets, userLotto, bonusNumber);
        calculateProfit(tickets.size());
    }

    private void setResults(List<Lotto> tickets, Lotto userLotto, int bonusNumber) {
        for (Lotto lotto : tickets) {
            Rank rank = userLotto.compare(lotto, bonusNumber);
            if (rank != Rank.LOSE) {
                results.put(rank, results.getOrDefault(rank, 0) + 1);
            }
        }
    }

    private void calculateProfit(int ticketCount) {
        int ticketPrice = LottoMachine.PRICE * ticketCount;
        profit = (getTotalPrize() / ticketPrice) * 100;
        profit = Math.round(profit * 10) / 10f;
    }

    private int getTotalPrize() {
        int total = 0;
        for (Rank rank : Rank.values()) {
            int count = results.getOrDefault(rank, 0);
            total += (rank.getPrize() * count);
        }
        return total;
    }

    public float getProfit() {
        return profit;
    }
}
