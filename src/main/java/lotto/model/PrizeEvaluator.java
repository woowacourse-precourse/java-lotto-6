package lotto.model;

import java.util.List;

public class PrizeEvaluator {
    private static final int NO_MATCH_PRIZE = 0;
    private static final int THREE_MATCH_PRIZE = 5_000;
    private static final int FOUR_MATCH_PRIZE = 50_000;
    private static final int FIVE_MATCH_PRIZE = 1_500_000;
    private static final int FIVE_MATCH_WITH_BONUS_PRIZE = 30_000_000;
    private static final int SIX_MATCH_PRIZE = 2_000_000_000;
    private static final int THREE_MATCH_COUNT = 3;
    private static final int FOUR_MATCH_COUNT = 4;
    private static final int FIVE_MATCH_COUNT = 5;
    private static final int SIX_MATCH_COUNT = 6;

    private int threeMatchCount = 0;
    private int fourMatchCount = 0;
    private int fiveMatchCount = 0;
    private int fiveMatchWithBonusCount = 0;
    private int sixMatchCount = 0;

    public Prize evaluate(WinningNumbers winningNumbers, List<Lotto> lottos) {
        int bonusNumber = winningNumbers.getBonusNumber();

        int prizeMoney = 0;
        for (Lotto lotto : lottos) {
            int matchCount = countMatch(winningNumbers.getNumbers(), lotto.getNumbers());
            boolean isBonusMatch = lotto.getNumbers().contains(bonusNumber);

            prizeMoney += calculatePrize(matchCount, isBonusMatch);
        }

        return new Prize(prizeMoney, threeMatchCount, fourMatchCount, fiveMatchCount, fiveMatchWithBonusCount, sixMatchCount);
    }

    private int countMatch(List<Integer> winningNumbers, List<Integer> numbers) {
        return (int) winningNumbers.stream()
                .filter(numbers::contains)
                .count();
    }

    private int calculatePrize(int matchCount, boolean isBonusMatch) {
        if (matchCount == THREE_MATCH_COUNT) {
            threeMatchCount++;
            return THREE_MATCH_PRIZE;
        }
        if (matchCount == FOUR_MATCH_COUNT) {
            fourMatchCount++;
            return FOUR_MATCH_PRIZE;
        }
        if (matchCount == FIVE_MATCH_COUNT && isBonusMatch) {
            fiveMatchWithBonusCount++;
            return FIVE_MATCH_WITH_BONUS_PRIZE;
        }
        if (matchCount == FIVE_MATCH_COUNT) {
            fiveMatchCount++;
            return FIVE_MATCH_PRIZE;
        }
        if (matchCount == SIX_MATCH_COUNT) {
            sixMatchCount++;
            return SIX_MATCH_PRIZE;
        }
        return NO_MATCH_PRIZE;
    }
}
