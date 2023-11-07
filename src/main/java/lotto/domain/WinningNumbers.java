package lotto.domain;

import java.util.List;

import static lotto.common.Validation.validateBonusNum;
import static lotto.common.Validation.validateWinningNumbers;

public class WinningNumbers {

    private final List<Integer> winningNums;
    private final int bonusNum;

    public WinningNumbers(List<Integer> winningNums, int bonusNum) {
        validateWinningNumbers(winningNums);
        validateBonusNum(winningNums, bonusNum);
        this.winningNums = winningNums;
        this.bonusNum = bonusNum;
    }

    public List<Integer> getWinningNums() {
        return winningNums;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
