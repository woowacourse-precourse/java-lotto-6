package lotto.domain.dto;

import static lotto.validatior.InputWinningBonusNumberValidator.validateBonusNumberRange;
import static lotto.validatior.InputWinningBonusNumberValidator.validateOnlyPositiveNumberBonus;

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
