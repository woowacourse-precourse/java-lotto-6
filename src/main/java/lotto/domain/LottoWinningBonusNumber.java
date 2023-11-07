package lotto.domain;

import static lotto.validatior.InputWinningBonusNumberValidator.validateBonusNumberRange;
import static lotto.validatior.InputWinningBonusNumberValidator.validateOnlyPositiveNumberBonus;
import static lotto.validatior.InputWinningBonusNumberValidator.validateWinningBonusNumberAlreadyExists;

import java.util.List;

public class LottoWinningBonusNumber {
    private final int winningBonusNumber;

    public LottoWinningBonusNumber(String winningBonusNumberString, List<Integer> winningNumbers) {
        validateOnlyPositiveNumberBonus(winningBonusNumberString);
        int winningBonusNumber = convertToInteger(winningBonusNumberString);
        validateBonusNumberRange(winningBonusNumber);
        validateWinningBonusNumberAlreadyExists(winningBonusNumber, winningNumbers);
        this.winningBonusNumber = winningBonusNumber;
    }

    private int convertToInteger(String winningBonusNumberString) {
        return Integer.parseInt(winningBonusNumberString);
    }

    public int getWinningBonusNumber() {
        return winningBonusNumber;
    }
}
