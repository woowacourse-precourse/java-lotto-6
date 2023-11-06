package lotto.lotto;

import java.util.List;

public class LottoEvaluator {
    public LottoResult evaluateLotto(Lotto lotto, List<Integer> winningNumbers, Integer bonusNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();

        int winningCount = calculateWinningCount(winningNumbers, lottoNumbers);
        boolean isBonusNumberCorrect = lottoNumbers.contains(bonusNumber);

        int rank = determineRank(winningCount, isBonusNumberCorrect);
        return new LottoResult(rank);
    }

    private int calculateWinningCount(List<Integer> winningNumbers, List<Integer> lottoNumbers) {
        int winningCount = 0;
        for (Integer number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                winningCount++;
            }
        }
        return winningCount;
    }

    private int determineRank(int winningCount, boolean isBonusNumberCorrect) {
        if (winningCount == 6) {
            if (isBonusNumberCorrect) {
                return 1;
            }
            return 2;
        }
        return 8 - winningCount;
    }
}
