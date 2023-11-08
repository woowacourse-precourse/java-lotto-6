package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankCount {

    private final Map<Rank, Integer> rankCount;

    public RankCount(List<Lotto> tickets, List<Integer> winningNumbers, int bonusNumber) {
        this.rankCount = resultRank(tickets, winningNumbers, bonusNumber);
    }

    public RankCount(List<Lotto> tickets, WinningNumbers winningNumbers) {
        this(tickets, winningNumbers.getWinningNumbers(), winningNumbers.getBonusNumber());
    }

    private static Map<Rank, Integer> resultRank(List<Lotto> tickets, List<Integer> winningNumbers, int bonusNumber) {
        Map<Rank, Integer> rankCount = new HashMap<>();
        for (Lotto ticket : tickets) {
            int count = (int) winningNumbers.stream()
                    .filter(ticket.getLotto()::contains)
                    .count();
            boolean bonus = ticket.getLotto().contains(bonusNumber);
            Rank rank = Rank.valueOf(count, bonus);
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }
        return rankCount;
    }

    public int calculateTotalWinnings() {
        int totalWinnings = 0;
        for (Map.Entry<Rank, Integer> entry : rankCount.entrySet()) {
            totalWinnings += entry.getKey().getAmount() * entry.getValue();
        }
        return totalWinnings;
    }

    public Map<Rank, Integer> getRankCount() {
        return rankCount;
    }
}
