package lotto.domain;

import static lotto.validator.InputWinningBonusNumberValidator.validateWinningBonusNumberAlreadyExists;

import java.util.List;

public class WinningBonusNumber {
    private final int winningBonusNumber;

    public WinningBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validateWinningBonusNumberAlreadyExists(bonusNumber, winningNumbers);
        this.winningBonusNumber = bonusNumber;
    }


    public int getWinningBonusNumber() {
        return winningBonusNumber;
    }
}
