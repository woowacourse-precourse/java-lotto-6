package lotto.domain;

import java.util.List;
import lotto.domain.enums.LottoPrize;

public class WinningLotto {

    private List<Integer> winningNumbers;
    private BonusNumber bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, BonusNumber bonusNumber) {
        validateNoDuplicatedWinningNumbers(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoPrize matches(Lotto lotto) {
        int matchCount = lotto.getMatchCount(winningNumbers);
        boolean isBonusMatched = lotto.isBonusMatched(bonusNumber);
        return LottoPrize.findLottoPrize(matchCount, isBonusMatched);
    }

    private void validateNoDuplicatedWinningNumbers(List<Integer> winningNumbers,
        BonusNumber bonusNumber) {
        if (bonusNumber.isIn(winningNumbers)) {
            throw new IllegalArgumentException();
        }
    }
}
