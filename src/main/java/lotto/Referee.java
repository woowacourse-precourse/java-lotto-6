package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Referee {
    private static List<Rank> calculateAllLottoPrize(List<Lotto> lottoList, List<Integer> winningNumbers,
                                                     int bonusNumber) {
        return lottoList.stream()
                .map(lotto -> calculatePrize(lotto, winningNumbers, bonusNumber))
                .collect(Collectors.toList());
    }

    private static Rank calculatePrize(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        Set<Integer> userNumbers = new HashSet<>(lotto.getNumbers());
        Set<Integer> winningNumberSet = new HashSet<>(winningNumbers);

        boolean hasBonusNumber = userNumbers.contains(bonusNumber);

        long matchingNumbers = countMatchingNumbers(userNumbers, winningNumberSet);

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

    private static long countMatchingNumbers(Set<Integer> userNumbers, Set<Integer> winningNumberSet) {
        return userNumbers.stream()
                .filter(winningNumberSet::contains)
                .count();
    }
}