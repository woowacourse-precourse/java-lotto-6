package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import view.Output;

public class Referee {
    public static void calculateLottoResultAndProfit(List<Lotto> lottoTickets, List<Integer> winningNumbers,
                                                     int bonusNumber, int purchaseAmount) {
        Map<Rank, Long> winningCounts = countLottoRank(lottoTickets, winningNumbers, bonusNumber);
        Output.printLottoGameResult();

        long totalPrizeAmount = 0;
        for (Rank rank : Rank.values()) {
            long rankCount = winningCounts.getOrDefault(rank, 0L);
            long prizeAmount = rank.getPrize();

            totalPrizeAmount += (rankCount * prizeAmount);
            Output.handlePrizeDescription(rank, rankCount, prizeAmount);
        }
        double profitRate = (totalPrizeAmount / (double) purchaseAmount) * 100;
        Output.printLottoProfit(profitRate);
    }

    private static Map<Rank, Long> countLottoRank(List<Lotto> lottoTickets, List<Integer> winningNumbers,
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