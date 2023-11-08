package lotto;

import lotto.utils.Rank;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Calculation {
    public int calculateRankCount(List<Lotto> lottos, WinningNumber winningNumber, Rank rank) {
        return (int) lottos.stream()
                .map(lotto -> calculateRank(lotto, winningNumber))
                .filter(r -> r == rank)
                .count();
    }

    private Rank calculateRank(Lotto lotto, WinningNumber winningNumber) {
        int matchCount = countMatchedNumbers(lotto, winningNumber.getLotto());
        boolean hasBonus = lotto.getNumbers().contains(winningNumber.getBonusNumber());
        return Rank.findRank(matchCount, hasBonus);
    }

    private int countMatchedNumbers(Lotto userLotto, Lotto winningLotto) {
        List<Integer> userNumbers = userLotto.getNumbers();
        List<Integer> winningNumbers = winningLotto.getNumbers();

        return (int) userNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    // 모든 등수의 개수를 계산하는 메서드
    public Map<Rank, Integer> calculateAllRankCounts(List<Lotto> lottos, WinningNumber winningNumber) {
        return lottos.stream()
                .map(lotto -> calculateRank(lotto, winningNumber))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));
    }

    // 수익률을 계산하는 메서드
    public double calculateProfitRate(Map<Rank, Integer> rankCounts, int purchaseAmount) {
        long totalPrize = rankCounts.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
        return (totalPrize / (double) purchaseAmount) * 100;
    }
}
