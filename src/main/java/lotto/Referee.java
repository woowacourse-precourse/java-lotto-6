package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Referee {
    private static final long DEFAULT_VALUE = 0L;
    private static final int PERCENT_VALUE = 100;

    public static List<Map<Rank, Long>> getLottoResult(Map<Rank, Long> winningCounts) {
        List<Map<Rank, Long>> lottoResults = new ArrayList<>();
        for (Rank rank : Rank.values()) {
            long rankCount = winningCounts.getOrDefault(rank, DEFAULT_VALUE);

            Map<Rank, Long> resultAndProfit = new HashMap<>();
            resultAndProfit.put(rank, rankCount);
            lottoResults.add(resultAndProfit);
        }
        return lottoResults;
    }

    public static double getLottoProfit(Map<Rank, Long> winningCounts, int purchaseAmount) {
        long totalPrizeAmount = DEFAULT_VALUE;
        for (Rank rank : Rank.values()) {
            long rankCount = winningCounts.getOrDefault(rank, DEFAULT_VALUE);
            long prizeAmount = rank.getPrize();

            totalPrizeAmount += (rankCount * prizeAmount);
        }
        return (totalPrizeAmount / (double) purchaseAmount) * PERCENT_VALUE;
    }

    public static Map<Rank, Long> countLottoRank(List<Lotto> lottoTickets, List<Integer> winningNumbers,
                                                 int bonusNumber) {
        return calculateAllLottoPrize(lottoTickets, winningNumbers, bonusNumber)
                .stream()
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));
    }

    private static List<Rank> calculateAllLottoPrize(List<Lotto> lottoTickets, List<Integer> winningNumbers,
                                                     int bonusNumber) {
        return lottoTickets.stream()
                .map(lotto -> calculatePrize(lotto, winningNumbers, bonusNumber))
                .collect(Collectors.toList());
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