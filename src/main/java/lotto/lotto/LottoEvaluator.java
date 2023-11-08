package lotto.lotto;

import static lotto.global.Constant.LOTTO_BEST_RANK;
import static lotto.global.Constant.LOTTO_NUMBERS_COUNT;
import static lotto.global.Constant.LOTTO_WORST_RANK;

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
        if (winningCount == LOTTO_NUMBERS_COUNT.getNumber()) {
            return LOTTO_BEST_RANK.getNumber();
        }
        if (winningCount == LOTTO_NUMBERS_COUNT.getNumber() - 1) {
            if (isBonusNumberCorrect) {
                return LOTTO_BEST_RANK.getNumber() + 1;
            }
            return LOTTO_BEST_RANK.getNumber() + 2;
        }
        return LOTTO_NUMBERS_COUNT.getNumber() - winningCount + 2;
    }

    private int setValidRank(int rank) {
        if (IntegerUtil.checkNumberInRange(rank, LOTTO_BEST_RANK.getNumber(), LOTTO_WORST_RANK.getNumber())) {
            return rank;
        }
        return LOTTO_BEST_RANK.getNumber() - 1;
    }
}
