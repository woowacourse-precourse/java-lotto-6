package lotto.domain;

public class Referee {

    private WinningNumber winningNumber;

    public Referee(WinningNumber winningNumber) {
        this.winningNumber = winningNumber;
    }

    public int countLottosWithMatches(Lotto[] lottos, LottoPrize lottoPrize) {
        int count = 0;

        for (Lotto lotto: lottos) {
            int matchedNumberCount = countWinningNumber(lotto);
            boolean bonusNumber = containsBonusNumber(lotto);

            if (match(matchedNumberCount, bonusNumber, lottoPrize)) {
                count++;
            }
        }

        return count;
    }

    private int countWinningNumber(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(number -> winningNumber.containsWinningNumber(number))
                .count();
    }

    private boolean containsBonusNumber(Lotto lotto) {
        return winningNumber.containsBonusNumber(lotto.getNumbers());
    }

    private boolean match(int matchedCount, boolean bonusNumber, LottoPrize lottoPrize) {
        if (lottoPrize == LottoPrize.FIVE_MATCH_WITH_BONUS) {
            return matchedCount == lottoPrize.getMatchedNumbers() && bonusNumber;
        }

        if (lottoPrize == LottoPrize.FIVE_MATCH) {
            return matchedCount == lottoPrize.getMatchedNumbers() && !bonusNumber;
        }

        return matchedCount == lottoPrize.getMatchedNumbers();
    }
}
