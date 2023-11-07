package lotto.service;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoPrize;
import lotto.model.WinningNumbers;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberMatchingService {

    public EnumMap<LottoPrize, Integer> calculateWinCounts(
            List<Lotto> lottos, WinningNumbers winningNumbers, BonusNumber bonusNumber) {

        Set<Integer> winningNumber = new HashSet<>(winningNumbers.getWinningNumbers());
        EnumMap<LottoPrize, Integer> winCounts = initializeWinCount();

        for (Lotto lotto : lottos) {
            int matchCount = getMatchCount(lotto.getNumbers(), winningNumber);
            boolean bonusMatch = isBonusMatch(lotto.getNumbers(), bonusNumber.getBonusNumber(), matchCount);
            LottoPrize prize = determinePrize(matchCount, bonusMatch);
            if (prize != null) {
                winCounts.merge(prize, 1, Integer::sum);
            }
        }
        return winCounts;
    }

    private int getMatchCount(List<Integer> singleGameLottoNumbers, Set<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : singleGameLottoNumbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private boolean isBonusMatch(List<Integer> singleGameLottoNumbers, int bonusNumber, int matchCount) {
        return singleGameLottoNumbers.contains(bonusNumber) && matchCount == 5;
    }

    private LottoPrize determinePrize(int matchCount, boolean bonusMatch) {
        if (matchCount < 3) {
            return null;
        }
        if (bonusMatch) {
            return LottoPrize.FIVE_AND_BONUS_MATCH;
        }
        return LottoPrize.valueOf(matchCount);
    }

    private EnumMap<LottoPrize, Integer> initializeWinCount() {
        EnumMap<LottoPrize, Integer> winCount = new EnumMap<>(LottoPrize.class);
        for (LottoPrize prize : LottoPrize.values()) {
            winCount.put(prize, 0);
        }
        return winCount;
    }
}