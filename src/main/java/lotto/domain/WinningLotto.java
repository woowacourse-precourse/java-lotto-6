package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class WinningLotto {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoRanking calculateRanking(Lotto lotto) {
        int correctCount = countCorrectWinningNumber(lotto);
        boolean isCorrectBonusNumber = lotto.contains(bonusNumber);

        return findRankingByCondition(correctCount, isCorrectBonusNumber);
    }

    private LottoRanking findRankingByCondition(int correctCount, boolean isCorrectBonusNumber) {
        if (LottoRanking.SECOND.isCorrectCondition(correctCount)) {
            if (isCorrectBonusNumber) {
                return LottoRanking.SECOND;
            }
            return LottoRanking.THIRD;
        }

        return Arrays.stream(LottoRanking.values())
                .filter(rank -> rank.isCorrectCondition(correctCount))
                .findFirst()
                .orElse(LottoRanking.NO_LUCK);
    }

    private int countCorrectWinningNumber(Lotto lotto) {
        return (int) winningNumbers.stream()
                .filter(lotto::contains)
                .count();
    }
}
