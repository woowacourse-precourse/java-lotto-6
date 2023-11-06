package lotto.service;

import lotto.model.LottoPrize;

import java.util.EnumMap;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class NumberMatchingService {

    public EnumMap<LottoPrize, Integer> calculateResults(List<List<Integer>> allYourNums, List<Integer> winningNumbers, int bonusNumber) {
        EnumMap<LottoPrize, Integer> winCount = new EnumMap<>(LottoPrize.class);
        Set<Integer> winningNumbersSet = new HashSet<>(winningNumbers);

        for (List<Integer> yourNumbers : allYourNums) {
            LottoPrize prize = checkWinning(yourNumbers, winningNumbersSet, bonusNumber);
            if (prize != null) {
                winCount.merge(prize, 1, Integer::sum);
            }
        }

        return winCount;
    }

    private LottoPrize checkWinning(List<Integer> yourNumbers, Set<Integer> winningNumbersSet, int bonusNumber) {
        int matchCount = 0;
        for (int number : yourNumbers) {
            if (winningNumbersSet.contains(number)) {
                matchCount++;
            }
        }

        boolean bonusMatch = yourNumbers.contains(bonusNumber) && matchCount == 5;
        return determinePrize(matchCount, bonusMatch);
    }

    private LottoPrize determinePrize(int matchCount, boolean bonusMatch) {
        if (bonusMatch) {
            return LottoPrize.FIVE_AND_BONUS_MATCH;
        }
        return LottoPrize.valueOf(matchCount);
    }
}