package lotto.lotto;

import java.util.List;
import lotto.util.IntegerUtil;

public class LottoEvaluator {
    public Integer evaluateLottoRank(Lotto lotto, List<Integer> winningNumbers, Integer bonusNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();

        int winningCount = calculateWinningCount(winningNumbers, lottoNumbers);
        boolean isBonusNumberCorrect = lottoNumbers.contains(bonusNumber);

        int rank = determineRank(winningCount, isBonusNumberCorrect);
        return setValidRank(rank);
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
            return 1;
        }
        if (winningCount == 5) {
            if (isBonusNumberCorrect) {
                return 2;
            }
            return 3;
        }
        return 8 - winningCount;
    }

    private int setValidRank(int rank) {
        if (IntegerUtil.checkNumberInRange(rank, 1, 5)) {
            return rank;
        }
        return 0;
    }
}
