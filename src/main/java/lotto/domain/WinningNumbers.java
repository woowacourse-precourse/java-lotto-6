package lotto.domain;

import java.util.Collections;
import lotto.utils.ValidationUtil;

import java.util.List;

public class WinningNumbers {
    /**
     * 입력받은 당첨 번호를 갖고있는 Domain
     */
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        validateWinningNumbers(winningNumbers, bonusNumber);
        this.winningNumbers = Collections.unmodifiableList(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        ValidationUtil.validateCorrectNumbersCount(winningNumbers);
        ValidationUtil.validateNoDuplicates(winningNumbers);
        ValidationUtil.validateNumberRange(winningNumbers);
        ValidationUtil.validateBonusNumber(bonusNumber);
        ValidationUtil.validateBonusNumberNotInWinningNumbers(bonusNumber, winningNumbers);
    }

    public List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}