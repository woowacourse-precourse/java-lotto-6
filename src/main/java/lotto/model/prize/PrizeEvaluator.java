package lotto.model.prize;

import lotto.model.Lotto;
import lotto.model.winning.WinningNumbers;

import java.util.List;

public class PrizeEvaluator {
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

            PrizeType prizeType = PrizeType.valueOf(matchCount, isBonusMatch);
            prizeType.increasePrize(this, isBonusMatch);
        }

        int prizeMoney = calculatePrizeMoney();

        return new Prize(prizeMoney, threeMatchCount, fourMatchCount, fiveMatchCount, fiveMatchWithBonusCount, sixMatchCount);
    }

    private int countMatch(List<Integer> winningNumbers, List<Integer> numbers) {
        return (int) winningNumbers.stream()
                .filter(numbers::contains)
                .count();
    }

    public void increaseThreeMatchPrize() {
        threeMatchCount++;
    }

    public void increaseFourMatchPrize() {
        fourMatchCount++;
    }

    public void increaseFiveMatchPrize() {
        fiveMatchCount++;
    }

    public void increaseFiveMatchWithBonusPrize() {
        fiveMatchWithBonusCount++;
    }

    public void increaseSixMatchPrize() {
        sixMatchCount++;
    }

    private int calculatePrizeMoney() {
        return PrizeType.THREE_MATCH.getPrizeMoney() * threeMatchCount
                + PrizeType.FOUR_MATCH.getPrizeMoney() * fourMatchCount
                + PrizeType.FIVE_MATCH.getPrizeMoney() * fiveMatchCount
                + PrizeType.FIVE_MATCH_WITH_BONUS.getPrizeMoney() * fiveMatchWithBonusCount
                + PrizeType.SIX_MATCH.getPrizeMoney() * sixMatchCount;
    }
}
