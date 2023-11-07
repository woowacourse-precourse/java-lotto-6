package lotto.domain.prizecalculator;

import java.util.List;
import lotto.domain.Lotto;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, Integer bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> winningNumbers, Integer bonusNumber) {
        //TODO: 예외처리
        // - 1. 1 ~ 45 범위 체크
        // - 2. 중복값 체크
    }

    public int getWinCount(Lotto lotto) {
        return lotto.countMatching(winningNumbers);
    }

    public Boolean isBonusCorrect(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }


}
