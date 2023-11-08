package lotto;

import java.util.*;

public class LottoStatistics {
    private static final String RESULT_MESSAGE_FORMAT = "\n%s - %d개";
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
        profit = ((float)getTotalPrize() / ticketPrice) * 100;
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

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Rank rank : sortByPrize(Rank.values())) {
            if (rank == Rank.LOSE) continue;
            int count = results.getOrDefault(rank, 0);
            String currentLine = String.format(RESULT_MESSAGE_FORMAT, rank.getResultMessage(), count);
            result.append(currentLine);
        }
        return result.toString();
    }

    private List<Rank> sortByPrize(Rank[] rank) {
        List<Rank> sorted = new ArrayList<>(List.of(rank));
        Collections.sort(sorted, Comparator.comparingInt(Rank::getPrize));
        return sorted;
    }
}
