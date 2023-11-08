package lotto.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGameCalculator {

    public Map<Integer, Integer> calculateWinningStatistics(LottoTicket ticket, WinningNumbers winningNumbers) {
        Map<Integer, Integer> statistics = new HashMap<>();
        for (Lotto lotto : ticket.getLottos()) {
            int matchCount = getMatchCount(lotto.getNumbers(), winningNumbers.getWinningLotto().getNumbers());
            boolean bonusMatch = lotto.getNumbers().contains(winningNumbers.getBonusNumber());
            int prize = calculatePrize(matchCount, bonusMatch);
            statistics.put(prize, statistics.getOrDefault(prize, 0) + 1);
        }
        return statistics;
    }

    private int getMatchCount(List<Integer> ticketNumbers, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : ticketNumbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private int calculatePrize(int matchCount, boolean bonusMatch) {
        Prize prize = Prize.valueOf(matchCount, bonusMatch);
        return prize != null ? prize.getReward() : 0;
    }

    public double calculateProfitRate(int purchaseAmount, Map<Integer, Integer> statistics) {
        int totalPrize = statistics.entrySet().stream()
                .mapToInt(e -> e.getKey() * e.getValue())
                .sum();
        return ((double) totalPrize / purchaseAmount) * 100;
    }

}
