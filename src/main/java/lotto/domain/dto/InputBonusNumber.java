package lotto.domain.dto;

import static lotto.validatior.InputWinningBonusNumberValidator.validateBonusNumberRange;
import static lotto.validatior.InputWinningBonusNumberValidator.validateOnlyPositiveNumberBonus;
import static lotto.validatior.InputWinningBonusNumberValidator.validateWinningBonusNumberAlreadyExists;

import java.util.List;
import lotto.domain.LottoWinningNumbers;

public class InputBonusNumber {
    private final int inputBonusNumber;

    public InputBonusNumber(String inputBonusNumber) {
        validateOnlyPositiveNumberBonus(inputBonusNumber);
        int winningBonusNumber = convertToInteger(inputBonusNumber);
        validateBonusNumberRange(winningBonusNumber);
        this.inputBonusNumber = winningBonusNumber;
    }

    public int getInputBonusNumber() {
        return inputBonusNumber;
    }

    private int convertToInteger(String winningBonusNumberString) {
        return Integer.parseInt(winningBonusNumberString);
    }
}
