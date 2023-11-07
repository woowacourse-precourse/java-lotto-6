package lotto.domain;

import static lotto.validatior.InputWinningBonusNumberValidator.validateBonusNumberRange;
import static lotto.validatior.InputWinningBonusNumberValidator.validateOnlyPositiveNumberBonus;
import static lotto.validatior.InputWinningBonusNumberValidator.validateWinningBonusNumberAlreadyExists;

import java.util.List;

public class LottoWinningBonusNumber {
    private final int winningBonusNumber;

    public LottoWinningBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validateWinningBonusNumberAlreadyExists(bonusNumber, winningNumbers);
        this.winningBonusNumber = bonusNumber;
    }


    public int getWinningBonusNumber() {
        return winningBonusNumber;
    }
}
