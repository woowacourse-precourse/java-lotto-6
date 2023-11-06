package lotto.model;

import java.util.Arrays;
import java.util.List;

public class PrizeEvaluator {
    private static final int THREE_MATCH_PRIZE = 5_000;
    private static final int FOUR_MATCH_PRIZE = 50_000;
    private static final int FIVE_MATCH_PRIZE = 1_500_000;
    private static final int FIVE_MATCH_WITH_BONUS_PRIZE = 30_000_000;
    private static final int SIX_MATCH_PRIZE = 2_000_000_000;

    private int threeMatchCount = 0;
    private int fourMatchCount = 0;
    private int fiveMatchCount = 0;
    private int fiveMatchWithBonusCount = 0;
    private int sixMatchCount = 0;

    public Prize evaluate(WinningNumbers winningNumbers, List<Lotto> lottos) {
        int bonusNumber = winningNumbers.getBonusNumber();

        for (Lotto lotto : lottos) {
            int matchCount = countMatch(winningNumbers.getNumbers(), lotto.getNumbers());
            boolean isBonusMatch = lotto.getNumbers().contains(bonusNumber);

            checkMatch(matchCount, isBonusMatch);
        }

        int prizeMoney = calculatePrizeMoney();

        return new Prize(prizeMoney, threeMatchCount, fourMatchCount, fiveMatchCount, fiveMatchWithBonusCount, sixMatchCount);
    }

    private int countMatch(List<Integer> winningNumbers, List<Integer> numbers) {
        return (int) winningNumbers.stream()
                .filter(numbers::contains)
                .count();
    }

    private void checkMatch(int matchCount, boolean isBonusMatch) {
        List<Runnable> prizeIncreaseActions = Arrays.asList(
                this::noMatch,
                this::oneMatch,
                this::twoMatch,
                this::increaseThreeMatchPrize,
                this::increaseFourMatchPrize,
                () -> increaseFiveMatchPrize(isBonusMatch),
                this::increaseSixMatchPrize
        );

        prizeIncreaseActions.get(matchCount)
                .run();
    }

    private void noMatch() {
        // do nothing
    }

    private void oneMatch() {
        // do nothing
    }

    private void twoMatch() {
        // do nothing
    }

    private void increaseThreeMatchPrize() {
        threeMatchCount++;
    }

    private void increaseFourMatchPrize() {
        fourMatchCount++;
    }

    private void increaseFiveMatchPrize(boolean isBonusMatch) {
        if (isBonusMatch) {
            fiveMatchWithBonusCount++;
            return;
        }

        fiveMatchCount++;
    }

    private void increaseSixMatchPrize() {
        sixMatchCount++;
    }

    private int calculatePrizeMoney() {
       return (threeMatchCount * THREE_MATCH_PRIZE)
                    + (fourMatchCount * FOUR_MATCH_PRIZE)
                    + (fiveMatchCount * FIVE_MATCH_PRIZE)
                    + (fiveMatchWithBonusCount * FIVE_MATCH_WITH_BONUS_PRIZE)
                    + (sixMatchCount * SIX_MATCH_PRIZE);
    }
}
