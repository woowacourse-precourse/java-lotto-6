package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoRanking calculateRanking(Lotto lotto) {
        int correctCount = (int) winningNumbers.stream()
                .filter(lotto::contains)
                .count();

        boolean isCorrectBonusNumber = lotto.contains(bonusNumber);


        return LottoRanking.findByCondition(correctCount, isCorrectBonusNumber);
    }
}
