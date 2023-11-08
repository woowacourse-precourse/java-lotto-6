package lotto;

import java.util.List;

public class ResultChecker {

    public WinningStats checkResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        int threeMatchCount = 0;
        int fourMatchCount = 0;
        int fiveMatchCount = 0;
        int fiveAndBonusMatchCount = 0;
        int sixMatchCount = 0;

        for (Lotto lotto : lottos) {
            int matchCount = countMatchingNumbers(lotto, winningNumbers);
            if (matchCount == 3) {
                threeMatchCount++;
            } else if (matchCount == 4) {
                fourMatchCount++;
            } else if (matchCount == 5) {
                if (lotto.getNumbers().contains(bonusNumber)) {
                    fiveAndBonusMatchCount++;
                } else {
                    fiveMatchCount++;
                }
            } else if (matchCount == 6) {
                sixMatchCount++;
            }
        }

        return new WinningStats(threeMatchCount, fourMatchCount, fiveMatchCount, fiveAndBonusMatchCount, sixMatchCount);
    }

    private int countMatchingNumbers(Lotto lotto, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }
}
