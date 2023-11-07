package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Referee {
    private static final long DEFAULT_VALUE = 0L;
    private static final int PERCENT_VALUE = 100;

    public static double getLottoProfit(Map<Rank, Long> winningCounts, int purchaseAmount) {
        long totalPrizeAmount = Arrays.stream(Rank.values())
                .mapToLong(rank -> winningCounts.getOrDefault(rank, DEFAULT_VALUE) * rank.getPrize())
                .sum();

        return (totalPrizeAmount / (double) purchaseAmount) * PERCENT_VALUE;
    }

    public static Map<Rank, Long> countLottoRank(List<Lotto> lottoTickets, List<Integer> winningNumbers,
                                                 int bonusNumber) {
        return lottoTickets.stream()
                .collect(Collectors.groupingBy(
                        lotto -> calculatePrize(lotto, winningNumbers, bonusNumber),
                        Collectors.counting()
                ));
    }

    private static Rank calculatePrize(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        Set<Integer> userNumbers = new HashSet<>(lotto.getNumbers());
        Set<Integer> uniqueWinningNumbers = new HashSet<>(winningNumbers);

        boolean hasBonusNumber = userNumbers.contains(bonusNumber);

        long matchingNumbers = countMatchingNumbers(userNumbers, uniqueWinningNumbers);

        return calculatePrizeBasedOnMatching(matchingNumbers, hasBonusNumber);
    }

    private static Rank calculatePrizeBasedOnMatching(long matchingNumbers, boolean hasBonusNumber) {
        if (matchingNumbers == Rank.FIRST.getMatchCount() && !hasBonusNumber) {
            return Rank.FIRST;
        } else if (matchingNumbers == Rank.SECOND.getMatchCount() && hasBonusNumber) {
            return Rank.SECOND;
        } else if (matchingNumbers == Rank.THIRD.getMatchCount()) {
            return Rank.THIRD;
        } else if (matchingNumbers == Rank.FOURTH.getMatchCount()) {
            return Rank.FOURTH;
        } else if (matchingNumbers == Rank.FIFTH.getMatchCount()) {
            return Rank.FIFTH;
        }
        return Rank.FAIL;
    }

    private static long countMatchingNumbers(Set<Integer> userNumbers, Set<Integer> uniqueWinningNumbers) {
        return userNumbers.stream()
                .filter(uniqueWinningNumbers::contains)
                .count();
    }
}