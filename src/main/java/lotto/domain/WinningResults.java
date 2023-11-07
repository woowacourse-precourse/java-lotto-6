package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class WinningResults {
    private final Map<Rank, Integer> winningResult = new HashMap<>();

    public WinningResults(final LottoTicket ticket, final LuckyNumbers luckyNumbers) {
        for (Lotto lotto : ticket.getTicket()) {
            Rank rank = WinningCalculationService.calculateRank(lotto,luckyNumbers);
            addWinningResult(rank);
        }
    }

    public long calculatePrizeSum() {
        return winningResult.entrySet().stream()
                .mapToLong(entry -> entry.getKey().calculatePrize(entry.getValue()))
                .sum();
    }

    public Map<Rank, Integer> getWinningResult() {
        return winningResult;
    }
    
    public void addWinningResult(Rank rank) {
        winningResult.put(rank, winningResult.getOrDefault(rank, 0) + 1);
    }
}
