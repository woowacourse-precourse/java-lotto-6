package lotto.domain.prizecalculator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
        List<Integer> allNumbers = new ArrayList<>(winningNumbers);
        allNumbers.add(bonusNumber);
        if (allNumbers.size() != 7) {
            throw new IllegalArgumentException("당첨 번호는 6개 보너스 번호는 1개여야 합니다.");
        }
        for (Integer allNumber : allNumbers) {
            if (allNumber < 1 || allNumber > 45) {
                throw new IllegalArgumentException("당첨 번호와 보너스 번호는 1부터 45 사이여야 합니다.");
            }
        }
        Set<Integer> uniqueSet = new HashSet<>(allNumbers);
        if (uniqueSet.size() != allNumbers.size()) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호에는 중복이 들어갈 수 없습니다.");
        }

    }

    public int getWinCount(Lotto lotto) {
        return lotto.countMatching(winningNumbers);
    }

    public Boolean isBonusCorrect(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }

}
