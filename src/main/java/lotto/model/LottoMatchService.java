package lotto.model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.utils.Constants;

public class LottoMatchService {

    public List<Ranking> checkWinningNumbers(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        return lottos.stream()
                .map(lotto -> findMatches(lotto, winningNumbers, bonusNumber))
                .collect(Collectors.toList());
    }

    private Ranking findMatches(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        long matchCount = lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();

        boolean matchBonus = matchCount == Constants.MATCH_COUNT_FOR_BONUS && lotto.getNumbers().contains(bonusNumber);

        return Ranking.findByMatchCountAndBonus(matchCount, matchBonus);
    }

    public double computeRevenueRate(int ticketPrice, int ticketCount, Map<Ranking, Long> resultMap) {
        long amountSpent = (long) ticketPrice * ticketCount;
        long totalWinnings = resultMap.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        return Math.round((totalWinnings / (double) amountSpent) * 10000.0) / 100.0;
    }
}
