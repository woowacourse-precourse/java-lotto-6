package lotto.service;

import lotto.model.LottoPrize;

import java.util.EnumMap;
import java.util.List;


public class NumberMatchingService {

    public EnumMap<LottoPrize, Integer> calculateResults(List<List<Integer>> allYourNums, List<Integer> winningNumbers, int bonusNumber) {
        EnumMap<LottoPrize, Integer> winCount = new EnumMap<>(LottoPrize.class);

        for (LottoPrize prize : LottoPrize.values()) {
            winCount.put(prize, 0);
        }

        for (List<Integer> yourNumbers : allYourNums) {
            LottoMatchResult matchResult = checkWinning(yourNumbers, winningNumbers, bonusNumber);
            if (matchResult != null && matchResult.getPrize() != null) {
                int currentCount = winCount.get(matchResult.getPrize());
                winCount.put(matchResult.getPrize(), currentCount + 1);
            }
        }

        return winCount;
    }

    private LottoMatchResult checkWinning(List<Integer> yourNumbers, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = 0;
        boolean bonusMatch = false;

        for (int number : yourNumbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }

        bonusMatch = yourNumbers.contains(bonusNumber) && matchCount == 5;

        LottoPrize prize = determinePrize(matchCount, bonusMatch);
        return new LottoMatchResult(prize);
    }

    private LottoPrize determinePrize(int matchCount, boolean bonusMatch) {
        if (bonusMatch) {
            return LottoPrize.FIVE_AND_BONUS_MATCH;
        }
        for (LottoPrize prize : LottoPrize.values()) {
            if (prize.getMatchCount() == matchCount) {
                return prize;
            }
        }
        return null;
    }

    public static class LottoMatchResult {
        private final LottoPrize prize;

        public LottoMatchResult(LottoPrize prize) {
            this.prize = prize;
        }

        public LottoPrize getPrize() {
            return prize;
        }
    }
}