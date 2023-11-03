package lotto;

import java.util.List;

public class WinningLotto extends Lotto {
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        super(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public LottoRanking calculateRanking(Lotto lotto) {
        int correctCount = (int) lotto.numbers.stream()
                .filter(numbers::contains)
                .count();

        boolean isCorrectBonusNumber = lotto.numbers.contains(bonusNumber);


        return LottoRanking.findByCondition(correctCount, isCorrectBonusNumber);
    }
}
