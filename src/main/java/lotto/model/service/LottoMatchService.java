package lotto.model.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lotto.model.entity.Lotto;
import lotto.model.entity.Ranking;
import lotto.utils.Constants;

public class LottoMatchService {

    public List<Ranking> determineLottoRankings(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        return lottos.stream()
                .map(lotto -> Ranking.determineRanking(lotto, winningNumbers, bonusNumber))
                .collect(Collectors.toList());
    }

    public Map<Ranking, Long> summarizeRankings(List<Ranking> rankings) {
        return rankings.stream()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
    }

    public double calculateRevenueRate(int ticketPrice, int ticketCount, List<Ranking> rankings) {
        long amountSpent = (long) ticketPrice * ticketCount;
        long totalWinnings = calculateTotalWinnings(rankings);
        return computeRevenueRate(amountSpent, totalWinnings);
    }

    private long calculateTotalWinnings(List<Ranking> rankings) {
        Map<Ranking, Long> summary = summarizeRankings(rankings);
        return rankings.stream()
                .distinct()
                .mapToLong(ranking -> ranking.getPrize() * summary.getOrDefault(ranking, 0L))
                .sum();
    }

    private double computeRevenueRate(long amountSpent, long totalWinnings) {
        double revenueRate = (double) totalWinnings / amountSpent * Constants.PERCENT_MULTIPLIER;
        return Math.round(revenueRate * Constants.ROUNDING_FACTOR) / Constants.ROUNDING_FACTOR;
    }
}
