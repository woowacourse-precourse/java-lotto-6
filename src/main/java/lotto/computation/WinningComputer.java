package lotto.computation;

import lotto.domain.*;
import lotto.utility.FormatConverter;

import java.util.List;

import static lotto.configuration.RandomNumberConfig.COUNT;

public class WinningComputer {
    private static MatchCount matchCount;
    private static int currentIndex;

    public static Winning computeMatchCount(List<Integer> lottoNumbers, WinningNumbers winningNumbers) {
        matchCount = new MatchCount();
        currentIndex = 0;

        for (int i = 0; i < COUNT; i++) {
            matchTwoNumbers(lottoNumbers, winningNumbers, i);
        }

        return FormatConverter.toWinningFromIntValue(matchCount.getMatchCount());
    }

    public static Winning computeMatchCount(List<Integer> lottoNumbers, BonusNumber bonusNumber) {
        matchCount = new MatchCount();
        boolean isMatched = matchTwoNumbers(lottoNumbers, bonusNumber);

        if (isMatched) {
            return Winning.FIVE_BONUS;
        }

        return Winning.FIVE;
    }

    public static ReturnRate computeReturnRate(PurchaseAmount purchaseAmount, Winnings winnings) {
        int totalReturn = computeTotalReturn(winnings);
        return new ReturnRate(totalReturn / purchaseAmount.getPurchaseAmount());
    }

    private static void matchTwoNumbers
            (List<Integer> lottoNumbers, WinningNumbers winningNumbers, int index) {
        for (int j = currentIndex; j < COUNT; j++) {
            if (lottoNumbers.get(index) < winningNumbers.get(j)) {
                currentIndex = j;
                return;
            }

            if (lottoNumbers.get(index) == winningNumbers.get(j)) {
                matchCount.addMatchCount();
                currentIndex = j + 1;
                return;
            }
        }
    }

    private static boolean matchTwoNumbers
            (List<Integer> lottoNumbers, BonusNumber bonusNumber) {
        for (int lottoNumber : lottoNumbers) {
            if (lottoNumber == bonusNumber.getBonusNumber()) {
                return true;
            }
        }

        return false;
    }

    private static int computeTotalReturn(Winnings winnings) {
        int totalReturn = 0;

        for (int i = 3; i <= 7; i++) {
            WinningCount winningCount = winnings.getWinningCount();
            Winning winning = FormatConverter.toWinningFromIntValue(i);

            totalReturn += winningCount.getCount(i) * winning.getWinningReward();
        }

        return totalReturn;
    }
}
