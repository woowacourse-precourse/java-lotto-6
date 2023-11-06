package lotto.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoMatchService {

    public List<Ranking> determineLottoRankings(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        return lottos.stream()
                .map(lotto -> Ranking.determineRanking(lotto, winningNumbers, bonusNumber))
                .collect(Collectors.toList());
    }

    public List<Ranking> calculateWinners(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        return determineLottoRankings(lottos, winningNumbers, bonusNumber);
    }

    public Map<Ranking, Long> summarizeResults(List<Ranking> rankings) {
        return rankings.stream()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
    }

    public long calculateAmountSpent(int ticketPrice, int ticketCount) {
        return (long) ticketPrice * ticketCount;
    }

    public long calculateTotalWinnings(Map<Ranking, Long> resultMap) {
        return resultMap.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    public double computeRevenueRate(long amountSpent, long totalWinnings) {
        double revenueRate = (totalWinnings / (double) amountSpent) * 100.0;
        return Math.round(revenueRate * 100.0) / 100.0;
    }

    public double calculateRevenueRate(int ticketPrice, int ticketCount, Map<Ranking, Long> resultMap) {
        long amountSpent = calculateAmountSpent(ticketPrice, ticketCount);
        long totalWinnings = calculateTotalWinnings(resultMap);
        return computeRevenueRate(amountSpent, totalWinnings);
    }
}
