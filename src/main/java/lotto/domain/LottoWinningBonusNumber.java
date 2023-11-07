package lotto.domain;

import static lotto.validatior.InputWinningBonusNumberValidator.validateBonusNumberRange;
import static lotto.validatior.InputWinningBonusNumberValidator.validateOnlyPositiveNumberBonus;
import static lotto.validatior.InputWinningBonusNumberValidator.validateWinningBonusNumberAlreadyExists;

import java.util.List;

public class LottoWinningBonusNumber {
    private final int winningBonusNumber;

    public LottoWinningBonusNumber(String winningBonusNumber, List<Integer> winningNumbers) {
        validateOnlyPositiveNumberBonus(winningBonusNumber);
        int bonusNumber = convertToInteger(winningBonusNumber);
        validateBonusNumberRange(bonusNumber);
        validateWinningBonusNumberAlreadyExists(bonusNumber, winningNumbers);
        this.winningBonusNumber = bonusNumber;
    }

    private int convertToInteger(String winningBonusNumberString) {
        return Integer.parseInt(winningBonusNumberString);
    }

    public int getWinningBonusNumber() {
        return winningBonusNumber;
    }
}
